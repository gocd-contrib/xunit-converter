package com.tw.xunit.model.mstest;

/**
 * Created by nhudacin on 4/23/2015.
 */

import org.simpleframework.xml.Attribute;

public class Deployment {
    @Attribute(required = false)
    private String runDeploymentRoot;

    public Deployment() {
    }

    public Deployment(String runDeploymentRoot) {
        this.runDeploymentRoot = runDeploymentRoot;
    }

    public String getRunDeploymentRoot() {
        return runDeploymentRoot;
    }

    public void setRunDeploymentRoot(String runDeploymentRoot) {
        this.runDeploymentRoot = runDeploymentRoot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deployment that = (Deployment) o;

        if (runDeploymentRoot != null ? !runDeploymentRoot.equals(that.runDeploymentRoot) : that.runDeploymentRoot != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return runDeploymentRoot != null ? runDeploymentRoot.hashCode() : 0;
    }
}
