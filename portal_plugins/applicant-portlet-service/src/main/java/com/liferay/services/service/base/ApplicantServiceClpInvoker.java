package com.liferay.services.service.base;

import com.liferay.services.service.ApplicantServiceUtil;

import java.util.Arrays;


public class ApplicantServiceClpInvoker {
    private String _methodName22;
    private String[] _methodParameterTypes22;
    private String _methodName23;
    private String[] _methodParameterTypes23;

    public ApplicantServiceClpInvoker() {
        _methodName22 = "getBeanIdentifier";

        _methodParameterTypes22 = new String[] {  };

        _methodName23 = "setBeanIdentifier";

        _methodParameterTypes23 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName22.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
            return ApplicantServiceUtil.getBeanIdentifier();
        }

        if (_methodName23.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
            ApplicantServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
