package com.zang.api.domain;

public class FraudControlRuleElement {

    private FraudControlRule blocked;
    private FraudControlRule authorized;
    private FraudControlRule whitelisted;

    public FraudControlRule getBlocked() {
        return blocked;
    }

    public void setBlocked(FraudControlRule blocked) {
        this.blocked = blocked;
    }

    public FraudControlRule getAuthorized() {
        return authorized;
    }

    public void setAuthorized(FraudControlRule authorized) {
        this.authorized = authorized;
    }

    public FraudControlRule getWhitelisted() {
        return whitelisted;
    }

    public void setWhitelisted(FraudControlRule whitelisted) {
        this.whitelisted = whitelisted;
    }
}
