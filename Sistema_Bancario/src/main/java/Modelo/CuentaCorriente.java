/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class CuentaCorriente extends Cuenta {

    private double cupoSobregiro;

    public CuentaCorriente(String numero, String titular, Fecha fechaApertura, double cupoSobregiro) {
        super(numero, titular, fechaApertura);
        this.cupoSobregiro = cupoSobregiro;
    }

    public CuentaCorriente(String numero, String titular, Fecha fechaApertura, double saldoInicial, double cupoSobregiro) {
        super(numero, titular, fechaApertura, saldoInicial);
        this.cupoSobregiro = cupoSobregiro;
    }

    public double getCupoSobregiro() {
        return cupoSobregiro;
    }

    @Override
    public boolean retirar(double valor) {
        if (valor <= 0) {
            return false;
        }
        if (valor <= saldo + cupoSobregiro) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public String mostrarDatos() {
        return "Tipo de cuenta: Corriente\n" + super.mostrarDatos()
                + "\nCupo de sobregiro: " + cupoSobregiro;
    }
}