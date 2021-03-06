/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac;

/**
 *
 * @author S
 */

public class PermissionModel {
    private DocumentModel doc;
    private UserModel user;
    private boolean read;
    private boolean write;
    
    public PermissionModel(){
        this.read = false;
        this.write = false;
    }
    
    public PermissionModel(DocumentModel doc, UserModel user){
        this.doc = doc;
        this.user = user;
        this.read = false;
        this.write = false;
    }
    
    public PermissionModel(DocumentModel doc, UserModel user, String permissions){
        this.doc = doc;
        this.user = user;
        if(permissions.length()>=1 && permissions.length()<=2){
            permissions = permissions.toUpperCase();
            this.read = permissions.contains("R");
            this.write = permissions.contains("W");
        }else{
            this.read = false;
            this.write = false;
        }
    }
    
    public PermissionModel(DocumentModel doc, UserModel user, boolean read,boolean write){
        this.doc = doc;
        this.user = user;
        this.read = read;
        this.write = write;
    }
    
    public PermissionModel(String permissions){
        permissions = permissions.toUpperCase();
        this.read = permissions.contains("R");
        this.write = permissions.contains("W");
    }
    
    public void togglePermissions(){
        this.read = !this.read;
        this.write = !this.write;
    }
    
    public void toggleRead(){
        this.read = !this.read;
    }
    
    public void toggleWrite(){
        this.write = !this.write;
    }
    
    public boolean getRead(){
        return this.read;
    }
    
    public boolean getWrite(){
        return this.write;
    }
    
    public void setRead(boolean read){
        this.read = read;
    }
    
    public void setWrite(boolean write){
        this.write = write;
    }
    
    @Override
    public String toString(){
        String permissions = "";
        
        if(this.read)
            permissions+="w";
        else
            permissions+="-";
        
        if(this.write)
            permissions+="r";
        else
            permissions+="-";
        
        return permissions;
    }

    public DocumentModel getDoc() {
        return doc;
    }

    public void setDoc(DocumentModel doc) {
        this.doc = doc;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
    
    public void setPermissions(String permissions){
        if(permissions.length()>=1 && permissions.length()<=2){
            permissions = permissions.toUpperCase();
            this.read = permissions.contains("R");
            this.write = permissions.contains("W");
        }else{
            this.read = false;
            this.write = false;
        }
    }
}
