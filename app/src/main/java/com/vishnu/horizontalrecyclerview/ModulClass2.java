package com.vishnu.horizontalrecyclerview;

import java.util.ArrayList;
import java.util.List;

public class ModulClass2 {

    public class Body {
        private String mode;
        private List<Formdatum> formdata = new ArrayList<Formdatum>();
        public String getMode() {
            return mode;
        }
        public void setMode(String mode) {
            this.mode = mode;
        }
        public List<Formdatum> getFormdata() {
            return formdata;
        }
        public void setFormdata(List<Formdatum> formdata) {
            this.formdata = formdata;
        }

    }
    public class Formdatum {
        private String key;
        private String value;
        private String type;
        public String getKey() {
            return key;
        }
        public void setKey(String key) {
            this.key = key;
        }
        public String getValue() {
            return value;
        }
        public void setValue(String value) {
            this.value = value;
        }
        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }
    }

    public class Info {
        private String postmanId;
        private String name;
        private String schema;
        public String getPostmanId() {
            return postmanId;
        }
        public void setPostmanId(String postmanId) {
            this.postmanId = postmanId;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getSchema() {
            return schema;
        }
        public void setSchema(String schema) {
            this.schema = schema;
        }
    }

    public class Item {
        private String name;
        private String id;
        private Request request;
        private List<Object> response = new ArrayList<Object>();
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public Request getRequest() {
            return request;
        }
        public void setRequest(Request request) {
            this.request = request;
        }
        public List<Object> getResponse() {
            return response;
        }
        public void setResponse(List<Object> response) {
            this.response = response;
        }
    }

    public class Request {
        private String method;
        private List<Object> header = new ArrayList<Object>();
        private Body body;
        private String url;
        public String getMethod() {
            return method;
        }
        public void setMethod(String method) {
            this.method = method;
        }
        public List<Object> getHeader() {
            return header;
        }
        public void setHeader(List<Object> header) {
            this.header = header;
        }
        public Body getBody() {
            return body;
        }
        public void setBody(Body body) {
            this.body = body;
        }
        public String getUrl() {
            return url;
        }
        public void setUrl(String url) {
            this.url = url;
        }
    }

    public class Root {
        private Info info;
        private List<Item> item = new ArrayList<Item>();
        public Info getInfo() {
            return info;
        }
        public void setInfo(Info info) {
            this.info = info;
        }
        public List<Item> getItem() {
            return item;
        }
        public void setItem(List<Item> item) {
            this.item = item;
        }
    }
}
