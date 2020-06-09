package com.easyContact.mobileapp.data.servicesModel;

import java.util.List;

public class OrdersInfo {
    private final List<WareNames> wareNames;

    private final List<ExecutorsNames> executorsNames;

    private final List<PrincipalNames> principalNames;

    public OrdersInfo(List<WareNames> wareNames, List<ExecutorsNames> executorsNames,
                      List<PrincipalNames> principalNames) {
        this.wareNames = wareNames;
        this.executorsNames = executorsNames;
        this.principalNames = principalNames;
    }

    public List<WareNames> getWareNames() {
        return wareNames;
    }

    public List<ExecutorsNames> getExecutorsNames() {
        return executorsNames;
    }

    public List<PrincipalNames> getPrincipalNames() {
        return principalNames;
    }

    public static class WareNames {
        private final int id;

        private final String name;

        public WareNames(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static class ExecutorsNames {
        private final int id;

        private final String name;

        public ExecutorsNames(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static class PrincipalNames {
        private final int id;

        private final String name;

        public PrincipalNames(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
