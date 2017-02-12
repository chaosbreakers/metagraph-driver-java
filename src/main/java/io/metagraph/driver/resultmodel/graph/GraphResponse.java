package io.metagraph.driver.resultmodel.graph;

import java.util.List;

/**
 * Created by (zhaoliang@metagraph.io) on (17-2-10).
 */
public class GraphResponse {

    /**
     * result : {"data":[{"id":1,"label":"graph","type":"vertex","properties":{"name":[{"id":0,"value":"mg-graph"}]}}],"meta":{}}
     * request_id : 4f62ff27-aabb-4b8c-85df-44b0a6355870
     * status : {"code":200,"attributes":{},"message":""}
     */
    private ResultEntity result;
    private String request_id;
    private StatusEntity status;

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

    public ResultEntity getResult() {
        return result;
    }

    public String getRequest_id() {
        return request_id;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public class ResultEntity {
        /**
         * data : [{"id":1,"label":"graph","type":"vertex","properties":{"name":[{"id":0,"value":"mg-graph"}]}}]
         * meta : {}
         */
        private List<DataEntity> data;
        private MetaEntity meta;

        public void setData(List<DataEntity> data) {
            this.data = data;
        }

        public void setMeta(MetaEntity meta) {
            this.meta = meta;
        }

        public List<DataEntity> getData() {
            return data;
        }

        public MetaEntity getMeta() {
            return meta;
        }

        public class DataEntity {
            /**
             * id : 1
             * label : graph
             * type : vertex
             * properties : {"name":[{"id":0,"value":"mg-graph"}]}
             */
            private int id;
            private String label;
            private String type;
            private PropertiesEntity properties;

            public void setId(int id) {
                this.id = id;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public void setType(String type) {
                this.type = type;
            }

            public void setProperties(PropertiesEntity properties) {
                this.properties = properties;
            }

            public int getId() {
                return id;
            }

            public String getLabel() {
                return label;
            }

            public String getType() {
                return type;
            }

            public PropertiesEntity getProperties() {
                return properties;
            }

            public class PropertiesEntity {
                /**
                 * name : [{"id":0,"value":"mg-graph"}]
                 */
                private List<NameEntity> name;

                public void setName(List<NameEntity> name) {
                    this.name = name;
                }

                public List<NameEntity> getName() {
                    return name;
                }

                public class NameEntity {
                    /**
                     * id : 0
                     * value : mg-graph
                     */
                    private int id;
                    private String value;

                    public void setId(int id) {
                        this.id = id;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }

                    public int getId() {
                        return id;
                    }

                    public String getValue() {
                        return value;
                    }
                }
            }
        }

        public class MetaEntity {
        }
    }

    public class StatusEntity {
        /**
         * code : 200
         * attributes : {}
         * message :
         */
        private int code;
        private AttributesEntity attributes;
        private String message;

        public void setCode(int code) {
            this.code = code;
        }

        public void setAttributes(AttributesEntity attributes) {
            this.attributes = attributes;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public AttributesEntity getAttributes() {
            return attributes;
        }

        public String getMessage() {
            return message;
        }

        public class AttributesEntity {
        }
    }
}
