package com.application.builder.relatedEntities;

public class PostOffice {
    public enum PostOfficeCode{
        OCA,
        ANDREANI,
        CORREO_ARGENTINO
    }
    public enum PostOfficeBranch {
        NORTH, EAST, CENTER
    }

    private PostOfficeCode code;

    // Sucursal
    private PostOfficeBranch branch;

    public PostOfficeCode getCode() {
        return code;
    }

    public void setCode(PostOfficeCode code) {
        this.code = code;
    }

    public PostOfficeBranch getBranch() {
        return branch;
    }

    public void setBranch(PostOfficeBranch branch) {
        this.branch = branch;
    }

    private PostOffice(PostOfficeCode code, PostOfficeBranch branch){
        this.code = code;
        this.branch = branch;
    }

    // Más clara la construcción por medio de un método estático fábrica.
    public static PostOffice newInstance(PostOfficeCode code, PostOfficeBranch branch){
        return new PostOffice(code, branch);
    }
}
