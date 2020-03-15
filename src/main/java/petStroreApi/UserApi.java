package petStroreApi;

import com.github.javafaker.Faker;
import user.UserData;
import utils.FileReaderUtil;
import utils.JsonUtil;

import java.io.IOException;

public class UserApi {
    private Faker faker = new Faker();
    private Integer id = faker.number().randomDigit();
    private String username = faker.name().username();
    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String email = "test@test.com" ;
    private String password = String.valueOf(faker.number().randomDigit());
    private String phone = faker.phoneNumber().phoneNumber();
    private Integer userStatus = Integer.valueOf(faker.number().digits(1));

    public String getUserName() {
        return username;
    }

    private UserData getUserJson(String stringToParse) throws IOException {
        UserData user = JsonUtil.createObjectFromJson(stringToParse, UserData.class);
        user.id = id;
        user.username = username;
        user.firstName = firstName;
        user.lastName = lastName;
        user.email = email ;
        user.password = password;
        user.phone = phone;
        user.userStatus = userStatus;

        return user;
    }

    public void actionsWithUser(String action) throws IOException {
        String requestUrl = "https://petstore.swagger.io";
        String fileName = "src/test/java/jsonFiles/user.json";
        String acceptHeader = "application/json";

        String stringToParse = JsonUtil.createJsonFormObject(getUserJson(FileReaderUtil.readFile(fileName)));

        if(action.equals("create")) {
            requestUrl = requestUrl + "/v2/user";
        } else if(action.equals("delete")) {
            requestUrl = requestUrl + "/v2/user/" + username + "";
        } else {
            System.out.println("Undefined action is selected");
        }

        ResponseHandler
                .getPostApiResponse(
                        acceptHeader,
                        stringToParse,
                        requestUrl,
                        "",
                        200,
                        action).asString();
    }
}
