package com.zang.api.domain.list;

import com.zang.api.domain.FraudControlRule;
import com.zang.api.domain.FraudControlRuleElement;
import com.zang.api.domain.ZangList;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class FraudControlRulesList extends ZangList<FraudControlRuleElement> {

    private List<FraudControlRule> blocked;
    private List<FraudControlRule> authorized;
    private List<FraudControlRule> whitelisted;

    public List<FraudControlRule> getBlocked() {
        return blocked;
    }

    public void setBlocked(List<FraudControlRule> blocked) {
        this.blocked = blocked;
    }

    public List<FraudControlRule> getAuthorized() {
        return authorized;
    }

    public void setAuthorized(List<FraudControlRule> authorized) {
        this.authorized = authorized;
    }

    public List<FraudControlRule> getWhitelisted() {
        return whitelisted;
    }

    public void setWhitelisted(List<FraudControlRule> whitelisted) {
        this.whitelisted = whitelisted;
    }

    @Override
    @JsonProperty("frauds")
    protected void mapElements(List<FraudControlRuleElement> elements) {
        setElements(elements);
    }
}
