/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac;
    
import com.UPV.MITSS.TFM.DocFacDPLfw.JSONAdapter.DocumentAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author S
 */
public class DocumentModel {
    private int id;
    @NotBlank
    @Length(max=255)
    private String title;
    @Length(max=255)
    private String description;
    private Date creation;
    private Date lastEdition;
    private UserModel author;
    private Map<Integer,PermissionModel> permissions = new HashMap<>(); // Integer = id_User
    private Map<Integer,FeatureModel> features = new HashMap<>(); // Integer = id_Feature

    public DocumentModel(){
        this.creation = new Date();
        this.permissions = new HashMap<>();
        this.features = new HashMap<>();
    }
    
    public DocumentModel(String title, String description, Date creation, Date lastEdition, UserModel author, Map<Integer, PermissionModel> permissions, Map<Integer, FeatureModel> features) {
        this.title = title;
        this.description = description;
        this.creation = creation;
        this.lastEdition = lastEdition;
        this.author = author;
        this.permissions = permissions;
        this.features = features;
    }

    public DocumentModel(int id, String title, String description, Date creation, Date lastEdition,UserModel author, Map<Integer, PermissionModel> permissions, Map<Integer, FeatureModel> features) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creation = creation;
        this.lastEdition = lastEdition;
        this.author = author;
        this.permissions = permissions;
        this.features = features;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Date getLastEdition() {
        return lastEdition;
    }

    public void setLastEdition(Date lastEdition) {
        this.lastEdition = lastEdition;
    }

    public UserModel getAuthor() {
        return this.author;
    }

    public void setAuthor(UserModel author) {
        this.author = author;
    }

    public Map<Integer, PermissionModel> getPermissions() {
        return this.permissions;
    }

    public void setPermissions(Map<Integer, PermissionModel> permissions) {
        this.permissions = permissions;
    }

    public Map<Integer, FeatureModel> getFeatures() {
        return this.features;
    }

    public void setFeatures(Map<Integer, FeatureModel> features) {
        this.features = features;
    }
    
    public void setFeatures(int id, FeatureModel features){
        this.features.putIfAbsent(id, features);
    }
    
    public FeatureModel getFeatures(int id){
        return this.features.get(id);
    }
    
    public void setFeature(int id, FeatureModel fueature){
        this.features.putIfAbsent(id, fueature);
    }
    
    public FeatureModel getFeature(int id){
        return this.features.get(id);
    }
    
    public void setPermission(int id, PermissionModel permission){
        this.permissions.putIfAbsent(id, permission);
    }
    
    public PermissionModel getPermission(int id){ // id_Usuario
        return this.permissions.get(id);
    }
    
    public String toJSON(){
        Gson json = new GsonBuilder().registerTypeAdapter(DocumentModel.class, new DocumentAdapter()).create();
        
        return "\""+this.id+"\":"+json.toJson(this);
    }
}
