package model;

public class AdminModel {
    // attributes of admin
    private int admin_id;
    private String admin_username;
    private String admin_password;
    private String created_at;
    private String updated_at;
    
    /**
     * @return admin_id
     */
    public int getAdminId(){
        return this.admin_id;
    }
    
    /**
     * @param param_admin_id
     */
    public void setAdminId(int param_admin_id){
        this.admin_id = param_admin_id;
    }
    
    public String getAdminUsername(){
        return this.admin_username;
    }
    
    public void setAdminUsername(String param_username){
        this.admin_username = param_username;
    }
    
    public String getAdminPassword(){
        return this.admin_password;
    }
    
    public void setAdminPassword(String param_password){
        this.admin_password = param_password;
    }
    
    public String getCreatedAt(){
        return this.created_at;
    }
    
    public void setCreatedAt(String param_date){
        this.created_at = param_date;
    }
    
    public String getUpdatedAt(){
        return this.updated_at;
    }
    
    public void setUpdatedAt(String param_date){
        this.updated_at = param_date;
    }
}
