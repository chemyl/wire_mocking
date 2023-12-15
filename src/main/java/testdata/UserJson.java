package testdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserJson {

    @JsonProperty("id")
    private String id;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("company")
    private String company;
    @JsonProperty("currency")
    private String currency;

    public void setId(String id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
