/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public abstract class Cuenta {
    
    protected String numero;
    protected String titular;
    protected Fecha fechaApertura;   
    protected double saldo;

    public Cuenta(String numero, String titular, Fecha fechaApertura) {
        this(numero, titular, fechaApertura, 0);
    }

    public Cuenta(String numero, String titular, Fecha fechaApertura, double saldoInicial) {
        this.numero = numero;
        this.titular = titular;
        this.fechaApertura = fechaApertura;
        this.saldo = saldoInicial;
    }

    public boolean consignar(double valor) {
        if (valor <= 0) {
            return false;
        }
        saldo += valor;
        return true;
    }

    public abstract boolean retirar(double valor);

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public Fecha getFechaApertura() {
        return fechaApertura;
    }

    public double getSaldo() {
        return saldo;
    }

    public String mostrarDatos() {
        return "Número: " + numero
                + "\nTitular: " + titular
                + "\nFecha de apertura: " + fechaApertura.mostrarFecha()
                + "\nSaldo: " + saldo;
    }

    public String mostrarDatos(boolean soloSaldo) {
        if (soloSaldo) {
            return "Saldo: " + saldo;
        }
        return mostrarDatos();
    }
}