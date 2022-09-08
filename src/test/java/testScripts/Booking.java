package testScripts;

import apiMethods.AuthKeys;
import apiMethods.Global;
import apiMethods.Common;
import org.testng.annotations.Test;

public class Booking {

    @Test
    public void getBooking()
    {
        Global.authKey = AuthKeys.getAuthKey();
        Common.createRequest("/booking/6670");
        Common.createFinalRequest();
        Common.createResponse();
        Common.createFinalResponse();
        Common.finalExecution("get");
        System.out.println(Global.response.prettyPrint());

    }

    @Test
    public void newBooking()
    {
        Global.authKey = AuthKeys.getAuthKey();
        Common.createRequest("/booking");
        Common.createBody("firstname", "Pankaj45");
        Common.createBody("lastname", "Khare45");
        Common.createBody("totalprice", 1500);
        Common.createBody("depositpaid", true);
        Common.createSubBody("checkin", "2022-10-05");
        Common.createSubBody("checkout", "2022-10-06");
        Common.createBody("bookingdates", Global.nestedObject);
        Common.createBody("additionalneeds", "dinner");
        Common.addBody();
        Common.createFinalRequest();
        Common.createResponse();
        Common.createFinalResponse();
        Common.finalExecution("post");
        System.out.println(Global.response.statusCode());
        System.out.println(Global.response.prettyPrint());

    }
    @Test
    public void updateBooking()
    {
        Global.authKey = AuthKeys.getAuthKey();
        Common.createRequest("/booking/6670");
        Common.createBody("firstname", "Varsha");
        Common.createBody("lastname", "Khare Nigam");

        Common.addBody();
        Common.createFinalRequest();
        Common.createResponse();
        Common.createFinalResponse();
        Common.finalExecution("patch");
        System.out.println(Global.response.statusCode());
        System.out.println(Global.response.prettyPrint());

    }

    @Test
    public void deleteBooking()
    {
        Global.authKey = AuthKeys.getAuthKey();
        Common.createRequest("/booking/6670");
        Common.createFinalRequest();
        Common.createResponse();
        Common.createFinalResponse();
        Common.finalExecution("delete");
        System.out.println(Global.response.statusCode());
        System.out.println(Global.response.prettyPrint());

    }
}
