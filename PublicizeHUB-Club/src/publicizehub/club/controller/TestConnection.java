/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicizehub.club.controller;

import publicizehub.club.model.ConnectionBuilder;

/**
 *
 * @author ImagineRabbits
 */
public class TestConnection {
    public static void main(String[] args) {
        ConnectionBuilder cb = new ConnectionBuilder();
        cb.connecting();
        cb.logout();
    }
}