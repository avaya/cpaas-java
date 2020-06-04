package com.zang.api.unit;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;
import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import com.zang.api.domain.ZangList;
import com.zang.api.inboundxml.elements.Response;
import org.junit.Test;

public class PojoTest {

    @Test
    public void testPojoStructureAndBehavior() {
        Validator validator = ValidatorBuilder.create()
                .with(new GetterMustExistRule())
                .with(new SetterMustExistRule())
                .with(new SetterTester())
                .with(new GetterTester())
                .build();

        PojoClassFilter ignoreClasses = getFilter();
        validator.validate("com.zang.api.domain", new FilterPackageInfo(), ignoreClasses);
        validator.validate("com.zang.api.params", new FilterPackageInfo(), ignoreClasses);
        validator.validate("com.zang.api.inboundxml.elements", new FilterPackageInfo(), ignoreClasses);
        validator.validate("com.zang.api.exceptions", new FilterPackageInfo(), ignoreClasses);
        validator.validate("com.zang.api.configuration", new FilterPackageInfo(), ignoreClasses);
    }


    PojoClassFilter getFilter() {
        return new PojoClassFilter() {
            @Override
            public boolean include(PojoClass pojoClass) {
                if (pojoClass.getClazz() == ZangList.class) return false;
                if (pojoClass.getClazz() == Response.class) return false;
                if (pojoClass.getName().endsWith("Builder")) return false;
                return true;
            }
        };
    }

}
