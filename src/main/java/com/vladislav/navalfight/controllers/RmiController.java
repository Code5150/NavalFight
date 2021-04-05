package com.vladislav.navalfight.controllers;

import com.vladislav.navalfight.server.FightCalculations;

import javax.naming.Context;
import javax.naming.NamingException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RmiController {

    private static final String HOST = "rmi://localhost";
    private static final int PORT = 1099;
    private static final String METHODS_NAME = "FightCalculations";

    protected static FightCalculations serverMethods;

    public static FightCalculations getServerMethods() {
        return serverMethods;
    }

    public static void initRmiConnection() throws MalformedURLException, RemoteException, NotBoundException {

        var e = Naming.list(HOST);
        for(var name: e) System.out.println(name);

        serverMethods = (FightCalculations) Naming.lookup(HOST + "/" + METHODS_NAME);
    }

    private static void setPolicyAndSecurity(String policyPath) {
        System.setProperty("java.security.policy",policyPath);
        System.out.println(System.getProperty("java.security.policy"));
        System.setSecurityManager(new SecurityManager());
    }
}
