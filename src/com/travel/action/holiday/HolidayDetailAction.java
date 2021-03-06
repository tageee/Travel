package com.travel.action.holiday;

import com.opensymphony.xwork2.ActionSupport;
import com.travel.model.Holiday;
import com.travel.model.Retailer;
import com.travel.service.HolidayManager;
import com.travel.service.RetailerManager;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by tage on 8/31/16.
 */
public class HolidayDetailAction extends ActionSupport {
    private int holidayId;


    public int getHolidayId() {
        return holidayId;
    }

    public void setHolidayId(int holidayId) {
        this.holidayId = holidayId;
    }

    private RetailerManager retailerManager;

    public RetailerManager getRetailerManager() {
        return retailerManager;
    }

    public void setRetailerManager(RetailerManager retailerManager) {
        this.retailerManager = retailerManager;
    }

    private HolidayManager holidayManager;

    public HolidayManager getHolidayManager() {
        return holidayManager;
    }

    public void setHolidayManager(HolidayManager holidayManager) {
        this.holidayManager = holidayManager;
    }


    private Holiday holiday;


    public Holiday getHoliday() {
        return holiday;
    }

    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
    }

    List<Retailer> retailers;

    public List<Retailer> getRetailers() {
        return retailers;
    }

    public void setRetailers(List<Retailer> retailers) {
        this.retailers = retailers;
    }

    @Override
    public String execute() throws Exception {
        this.holiday = holidayManager.loadById(holidayId);

        if (holiday == null) {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.getSession().setAttribute("error_message", "not found");

            return ERROR;
        } else {

            this.retailers = retailerManager.getAll();
            return SUCCESS;
        }


    }
}
