package com.gsccs.sme.plat.rtable.model;

import java.util.Date;

public class ReportAttachT {
    private Long id;
    private Long reportid;
    private String itemid;
    private Long corpid;
    private Long svgid;
    private Long userid;
    private String filename;
    private String filepath;
    private String filetype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sme_report_attach.addtime
     *
     * @mbggenerated Thu Apr 14 22:53:07 CST 2016
     */
    private Date addtime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sme_report_attach.id
     *
     * @return the value of sme_report_attach.id
     *
     * @mbggenerated Thu Apr 14 22:53:07 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sme_report_attach.id
     *
     * @param id the value for sme_report_attach.id
     *
     * @mbggenerated Thu Apr 14 22:53:07 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    public Long getReportid() {
        return reportid;
    }

    public void setReportid(Long reportid) {
        this.reportid = reportid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sme_report_attach.itemid
     *
     * @return the value of sme_report_attach.itemid
     *
     * @mbggenerated Thu Apr 14 22:53:07 CST 2016
     */
    public String getItemid() {
        return itemid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sme_report_attach.itemid
     *
     * @param itemid the value for sme_report_attach.itemid
     *
     * @mbggenerated Thu Apr 14 22:53:07 CST 2016
     */
    public void setItemid(String itemid) {
        this.itemid = itemid == null ? null : itemid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sme_report_attach.corpid
     *
     * @return the value of sme_report_attach.corpid
     *
     * @mbggenerated Thu Apr 14 22:53:07 CST 2016
     */
    public Long getCorpid() {
        return corpid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sme_report_attach.corpid
     *
     * @param corpid the value for sme_report_attach.corpid
     *
     * @mbggenerated Thu Apr 14 22:53:07 CST 2016
     */
    public void setCorpid(Long corpid) {
        this.corpid = corpid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sme_report_attach.svgid
     *
     * @return the value of sme_report_attach.svgid
     *
     * @mbggenerated Thu Apr 14 22:53:07 CST 2016
     */
    public Long getSvgid() {
        return svgid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sme_report_attach.svgid
     *
     * @param svgid the value for sme_report_attach.svgid
     *
     * @mbggenerated Thu Apr 14 22:53:07 CST 2016
     */
    public void setSvgid(Long svgid) {
        this.svgid = svgid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sme_report_attach.userid
     *
     * @return the value of sme_report_attach.userid
     *
     * @mbggenerated Thu Apr 14 22:53:07 CST 2016
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sme_report_attach.userid
     *
     * @param userid the value for sme_report_attach.userid
     *
     * @mbggenerated Thu Apr 14 22:53:07 CST 2016
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sme_report_attach.filename
     *
     * @return the value of sme_report_attach.filename
     *
     * @mbggenerated Thu Apr 14 22:53:07 CST 2016
     */
    public String getFilename() {
        return filename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sme_report_attach.filename
     *
     * @param filename the value for sme_report_attach.filename
     *
     * @mbggenerated Thu Apr 14 22:53:07 CST 2016
     */
    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sme_report_attach.filepath
     *
     * @return the value of sme_report_attach.filepath
     *
     * @mbggenerated Thu Apr 14 22:53:07 CST 2016
     */
    public String getFilepath() {
        return filepath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sme_report_attach.filepath
     *
     * @param filepath the value for sme_report_attach.filepath
     *
     * @mbggenerated Thu Apr 14 22:53:07 CST 2016
     */
    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sme_report_attach.filetype
     *
     * @return the value of sme_report_attach.filetype
     *
     * @mbggenerated Thu Apr 14 22:53:07 CST 2016
     */
    public String getFiletype() {
        return filetype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sme_report_attach.filetype
     *
     * @param filetype the value for sme_report_attach.filetype
     *
     * @mbggenerated Thu Apr 14 22:53:07 CST 2016
     */
    public void setFiletype(String filetype) {
        this.filetype = filetype == null ? null : filetype.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sme_report_attach.addtime
     *
     * @return the value of sme_report_attach.addtime
     *
     * @mbggenerated Thu Apr 14 22:53:07 CST 2016
     */
    public Date getAddtime() {
        return addtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sme_report_attach.addtime
     *
     * @param addtime the value for sme_report_attach.addtime
     *
     * @mbggenerated Thu Apr 14 22:53:07 CST 2016
     */
    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
}