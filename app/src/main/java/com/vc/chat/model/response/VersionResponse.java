package com.vc.chat.model.response;

/**
 * @author Hikki
 */
public class VersionResponse {

    /**
     * version : 1.0.5
     * build : 201607181821
     * url : https://dn-rongcloud.qbox.me/app.plist
     */
    private IosEntity ios;
    /**
     * version : 1.0.5
     * url : http://downloads.rongcloud.cn/SealTalk_by_RongCloud_Android_v1_0_5.apk
     */

    private AndroidEntity android;

    public IosEntity getIos() {
        return ios;
    }

    public void setIos(IosEntity ios) {
        this.ios = ios;
    }

    public AndroidEntity getAndroid() {
        return android;
    }

    public void setAndroid(AndroidEntity android) {
        this.android = android;
    }

    public static class IosEntity {
        private String version;
        private String build;
        private String url;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getBuild() {
            return build;
        }

        public void setBuild(String build) {
            this.build = build;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class AndroidEntity {
        private String version;
        private String url;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
