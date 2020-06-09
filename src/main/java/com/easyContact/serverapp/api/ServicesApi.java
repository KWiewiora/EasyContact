package com.easyContact.serverapp.api;

import com.easyContact.serverapp.Util;
import com.easyContact.serverapp.dao.entity.*;
import com.easyContact.serverapp.manager.*;
import com.easyContact.serverapp.models.AuthResponse;
import com.easyContact.serverapp.models.Order;
import com.easyContact.serverapp.models.OrdersInfo;
import com.easyContact.serverapp.models.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/")
public class ServicesApi {


    private UserManager userManager;
    private WarehouseManager warehouseManager;
    private PrincipalManger principalManager;
    private SupplyCompaniesManager supplyCompaniesManager;
    private DeliveryOrdersManager deliveryOrdersManager;

    @EventListener(ApplicationReadyEvent.class)
    public void fillDb() {
        userManager.save(new User(1L, "wzium@gmail.com", "haslo123"));
        userManager.save(new User(2L, "szybkadostawa@gmail.com", "hasloikea23"));
        userManager.save(new User(3L, "marcin@gmail.com", "das23"));
        userManager.save(new User(4L, "czarek@gmail.com", "dagfdgds23"));
        userManager.save(new User(5L, "wojtek@gmail.com", "dagfdgds23"));
        userManager.save(new User(6L, "jazdunia@gmail.com", "dagfdgds23"));
        userManager.save(new User(7L, "wielkimagazyn@gmail.com", "dczxds23"));
        userManager.save(new User(8L, "niebieskimagazyn@gmail.com", "dczxds23"));
        userManager.save(new User(9L, "mojmagazyn@gmail.com", "dczxds23"));

        warehouseManager.save(new Warehouse(1L, "Wielki magazyn", "Poznanska, Wroclaw", "123456544", 7L));
        warehouseManager.save(new Warehouse(2L, "Niebieski magazyn", "Opatowicka, Warszawa", "+4832156544", 8L));
        warehouseManager.save(new Warehouse(3L, "Jego magazyn", "Sokolska, Katowice", "+4832153424", 9L));

        principalManager.save(new Principal(1L, "Czarek", "Katowicka, Chorzów", "+483321424", 4L));
        principalManager.save(new Principal(2L, "Wojtek", "Piotrkowska, Łódź", "+48647424", 5L));
        principalManager.save(new Principal(3L, "Marcin", "Wyszyńska, Łódź", "+4875657624", 3L));

        supplyCompaniesManager.save(new SupplyCompanies(1L, "Jazdunia", "Bieruta, Zabrze", "+481234124", 6L));
        supplyCompaniesManager.save(new SupplyCompanies(2L, "Ikea Dostawy", "Biała, Gdańsk", "+48789124", 2L));
        supplyCompaniesManager.save(new SupplyCompanies(3L, "XYZ Dostawy", "Zielona, Gdynia", "+48667898724", 1L));

        deliveryOrdersManager.save(new DeliveryOrder(3423L, "Skrzynki 20kg jabłka", "50", 1L, 3L, LocalDate.of(2020, 5, 19), null, 1L));
        deliveryOrdersManager.save(new DeliveryOrder(1223L, "Filety z dorsza- skrzynka 10kg", "20", 2L, 3L, LocalDate.of(2020, 5, 20), null, 1L));
        deliveryOrdersManager.save(new DeliveryOrder(7526L, "Majonez Kielecki- skrzynka 20kg", "100", 2L, 3L, LocalDate.of(2020, 6, 5), 2L, 1L));
    }

    @Autowired
    public ServicesApi(UserManager userManager, WarehouseManager warehouseManager, PrincipalManger principalManager, SupplyCompaniesManager supplyCompaniesManager, DeliveryOrdersManager deliveryOrdersManager) {
        this.userManager = userManager;
        this.warehouseManager = warehouseManager;
        this.principalManager = principalManager;
        this.supplyCompaniesManager = supplyCompaniesManager;
        this.deliveryOrdersManager = deliveryOrdersManager;
    }

    private List<Order> getOrders(List<DeliveryOrder> deliveryOrders) {
        return deliveryOrders.stream().map(this::mapDeliveryOrderToOrder).collect(Collectors.toList());
    }

    private Order mapDeliveryOrderToOrder(DeliveryOrder deliveryOrder) {
        return new Order.OrderBuilder()
                .id(deliveryOrder.getId())
                .ware(deliveryOrder.getWare())
                .quantity(deliveryOrder.getQuantity())
                .wareFromName(warehouseManager.getNameById(deliveryOrder.getFromId()))
                .wareToName(warehouseManager.getNameById(deliveryOrder.getToId()))
                .principalName(principalManager.getNameById(deliveryOrder.getPrincipalId()))
                .deliveryDate(deliveryOrder.getExpectedDeliveryTime())
                .executorName(supplyCompaniesManager.getNameById(deliveryOrder.getExecutorId()))
                .build();
    }

    @PostMapping("signUp")
    public boolean addUser(@RequestBody User user) {
        return this.userManager.save(user).getClass() == User.class;
    }


    @PostMapping("signIn")
    public AuthResponse signIn(@RequestBody User user) {
        return getContentOrNull(user, true);
    }

    public AuthResponse getContentOrNull(@RequestBody User user, boolean shouldValidate) {

        if (userManager.getIdByEmail(user.getEmail()) != null) {
            UserInfo warehouseContent = warehouseManager.getContent((userManager.getIdByEmail(user.getEmail())));
            UserInfo supplyCompaniesContent = supplyCompaniesManager.getContent(userManager.getIdByEmail(user.getEmail()));
            Principal principalContent = principalManager.getContent(userManager.getIdByEmail(user.getEmail()));
            AuthResponse authResponse;

            if (warehouseContent != null) {
                warehouseContent.setUserType(Util.WAREHOUSE);
                final List<DeliveryOrder> deliveryOrders = deliveryOrdersManager.getAllOrdersForWarehouse(warehouseContent.id, warehouseContent.id);
                authResponse = new AuthResponse(warehouseContent, getOrders(deliveryOrders));
                return authResponse;
            }
            if (supplyCompaniesContent != null) {
                supplyCompaniesContent.setUserType(Util.SUPPLY);
                final List<DeliveryOrder> deliveryOrders = deliveryOrdersManager.getAllOrdersByExecutor(supplyCompaniesContent.getId());
                authResponse = new AuthResponse(supplyCompaniesContent, getOrders(deliveryOrders));
                return authResponse;
            }
            if (principalContent != null) {
                principalContent.setUserType(Util.PRINCIPAL);
                final List<DeliveryOrder> deliveryOrders = deliveryOrdersManager.getAllOrdersByPrincipal(principalContent.getId());
                authResponse = new AuthResponse(principalContent, getOrders(deliveryOrders));
                return authResponse;
            }
        }
        return null;
    }

    @DeleteMapping("deleteDeliveryOrder")
    public AuthResponse deleteDeliveryOrder(@RequestParam Long deliveryOrderId, @RequestParam String email) throws EntityNotFoundException {
        deliveryOrdersManager.deleteById(deliveryOrderId);
        return getContentOrNull(new User(0L, email, ""), false);
    }

    @GetMapping("getOrdersInfo")
    public OrdersInfo getOrdersInfo() {
        final OrdersInfo ordersInfos = new OrdersInfo();
        ordersInfos.getWareNames().addAll(warehouseManager.getEntityWarehouseInfo());
        ordersInfos.getPrincipalNames().addAll(principalManager.getEntityPrincipalInfo());
        ordersInfos.getExecutorsNames().addAll(supplyCompaniesManager.getEntitySupplyCompaniesInfo());
        return ordersInfos;
    }


    @GetMapping("getUpdatedContent")
    public AuthResponse getUpdatedContent(@RequestParam String email) {
        return getContentOrNull(new User(0L, email, ""), false);
    }

    @PostMapping("insertDeliveryOrder")
    public AuthResponse insertDeliveryOrder(@RequestBody DeliveryOrder deliveryOrder,@RequestParam String email) {
        deliveryOrdersManager.save(deliveryOrder);
        return getContentOrNull(new User(0L, email, ""), false);
    }

}
