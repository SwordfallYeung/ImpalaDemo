package com.impala.model;

/**
 *  * @Author: Yang JianQiu
 *   * @Date: 2018/8/9 20:06
 *    * 帧码记录表
 *     */
public class ImsiRecord {

    private String id;
    private String imsi;
    private String imei;
    /**
 *      * 归属地
 *           */
    private String regional;
    /**
 *      * 运营商  0：移动 1：联通 2：电信 -1:未知
 *           */
    private Integer isp;
    /**
 *      * 网络类型 1G,2G,3G,4G
 *           */
    private String netType;
    /**
 *      * 电话号码
 *           */
    private String telephone;

    private String mac;
    /**
 *      * 是否上传  0表示未上传，1表示已上传
 *           */
    private Integer isUpload;
    /**
 *      * 创建时间
 *           */
    private Long createTime;
    /**
 *      * /抓取时间
 *           */
    private Long uptime;
    
    private String placeId;
    /**
 *      * 抓取场所 如阳光小区
 *           */
    private String placeName;
    /**
 *      * 帧码设备ID
 *           */
    private String deviceId;
    /**
 *      * 帧码设备名称 即标识
 *           */
    private String deviceName;
    /**
 *      * 经度
 *           */
    private Double lon;
    /**
 *      * 纬度
 *           */
    private Double lat;
    
    /**分片入库时间*/
    private Long sclieCreateTime;


    public Long getSclieCreateTime() {
		return sclieCreateTime;
	}

	public void setSclieCreateTime(Long sclieCreateTime) {
		this.sclieCreateTime = sclieCreateTime;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public Integer getIsp() {
        return isp;
    }

    public void setIsp(Integer isp) {
        this.isp = isp;
    }

    public String getNetType() {
        return netType;
    }

    public void setNetType(String netType) {
        this.netType = netType;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Integer getIsUpload() {
        return isUpload;
    }

    public void setIsUpload(Integer isUpload) {
        this.isUpload = isUpload;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUptime() {
        return uptime;
    }

    public void setUptime(Long uptime) {
        this.uptime = uptime;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}
