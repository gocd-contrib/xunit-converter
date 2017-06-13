package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/23/2015.
 */

import org.simpleframework.xml.Attribute;

public class Deployment {
    @Attribute(required = false)
    private String runDeploymentRoot;

    @Attribute(required = false)
    private String userDeploymentRoot;

    @Attribute(required = false)
    private String useDefaultDeploymentRoot;

    public Deployment() {
    }

    public Deployment(String runDeploymentRoot, String userDeploymentRoot, String useDefaultDeploymentRoot) {
        this.runDeploymentRoot = runDeploymentRoot;
        this.userDeploymentRoot = userDeploymentRoot;
        this.useDefaultDeploymentRoot = useDefaultDeploymentRoot;
    }

    public String getRunDeploymentRoot() {
        return runDeploymentRoot;
    }
    public String getUserDeploymentRoot() {
        return userDeploymentRoot;
    }

    public String getUseDefaultDeploymentRoot() {
        return useDefaultDeploymentRoot;
    }

    public void setRunDeploymentRoot(String runDeploymentRoot) {
        this.runDeploymentRoot = runDeploymentRoot;
    }

    public void setUserDeploymentRoot(String userDeploymentRoot) {
        this.userDeploymentRoot = userDeploymentRoot;
    }

    public void setUseDefaultDeploymentRoot(String useDefaultDeploymentRoot){
        this.useDefaultDeploymentRoot = useDefaultDeploymentRoot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deployment that = (Deployment) o;

        if (runDeploymentRoot != null ? !runDeploymentRoot.equals(that.runDeploymentRoot) : that.runDeploymentRoot != null)
            return false;
        if (userDeploymentRoot != null ? !userDeploymentRoot.equals(that.userDeploymentRoot) : that.userDeploymentRoot != null)
            return false;
        if (useDefaultDeploymentRoot != null ? !useDefaultDeploymentRoot.equals(that.useDefaultDeploymentRoot) : that.useDefaultDeploymentRoot != null)
            return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = runDeploymentRoot != null ? runDeploymentRoot.hashCode() : 0;
        result = 31 * result + (userDeploymentRoot != null ? userDeploymentRoot.hashCode() : 0);
        result = 31 * result + (useDefaultDeploymentRoot != null ? useDefaultDeploymentRoot.hashCode() : 0);

        return result;
    }
}
