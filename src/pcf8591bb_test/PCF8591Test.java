/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcf8591bb_test;

import i2c_dev.I2CUtils;
import i2c_dev.drivers.PCF8591Device;
import java.io.IOException;

/**
 *
 */
public class PCF8591Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            PCF8591Device adConverter = new PCF8591Device();
            
            System.out.println("Potentimeter Input : " + adConverter.analogRead(0));
            System.out.println("Potentimeter Input : " + adConverter.analogRead(0));
            System.out.println("Potentimeter Input : " + adConverter.analogRead(0));
            
            System.out.println("Photoregister Input : " + adConverter.analogRead(1));
            System.out.println("Photoregister Input : " + adConverter.analogRead(1));
            System.out.println("Photoregister Input : " + adConverter.analogRead(1));

            System.out.println("Themistor Input : " + adConverter.analogRead(2));
            System.out.println("Themistor Input : " + adConverter.analogRead(2));
            System.out.println("Themistor Input : " + adConverter.analogRead(2));
            
            System.out.println("LED dimming...");
            adConverter.analogWrite(0xff);
            I2CUtils.I2Cdelay(3000);

            adConverter.analogWrite(0xcf);
            I2CUtils.I2Cdelay(3000);
            
            adConverter.analogWrite(0xaf);
            I2CUtils.I2Cdelay(3000);

            adConverter.analogWrite(0x9f);
            I2CUtils.I2Cdelay(3000);
            
            adConverter.analogWrite(0x00);
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
    
}
