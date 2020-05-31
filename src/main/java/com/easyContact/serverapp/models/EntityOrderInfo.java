//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.easyContact.serverapp.models;

public class EntityOrderInfo {
    private Long id;
    private String name;

    EntityOrderInfo(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public static EntityOrderInfo.EntityOrderInfoBuilder builder() {
        return new EntityOrderInfo.EntityOrderInfoBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public static class EntityOrderInfoBuilder {
        private Long id;
        private String name;

        EntityOrderInfoBuilder() {
        }

        public EntityOrderInfo.EntityOrderInfoBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public EntityOrderInfo.EntityOrderInfoBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public EntityOrderInfo build() {
            return new EntityOrderInfo(this.id, this.name);
        }

        public String toString() {
            return "EntityOrderInfo.EntityOrderInfoBuilder(id=" + this.id + ", name=" + this.name + ")";
        }
    }
}
