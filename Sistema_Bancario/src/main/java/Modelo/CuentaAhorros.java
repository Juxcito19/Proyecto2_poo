/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class CuentaAhorros extends Cuenta {

    public CuentaAhorros(String numero, String titular, Fecha fechaApertura) {
        super(numero, titular, fechaApertura);
    }

    public CuentaAhorros(String numero, String titular, Fecha fechaApertura, double saldoInicial) {
        super(numero, titular, fechaApertura, saldoInicial);
    }
    @Override
    public boolean retirar(double valor) {
        if (valor <= 0) {
            return false;
        }
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public String mostrarDatos() {
        return "Tipo de cuenta: Ahorros\n" + super.mostrarDatos();
    }
}