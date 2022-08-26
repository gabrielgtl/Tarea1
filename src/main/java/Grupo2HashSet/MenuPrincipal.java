/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grupo2HashSet;

public class MenuPrincipal {
    private Set<Prestamo> listaPrestamos = new HashSet<>();
    private Set<Cliente> listaClientes = new HashSet<>();

    private SortedSet<Prestamo> listaPrestamosOrdenados = new TreeSet<>();
    private SortedSet<Cliente> listaClientesOrdenados = new TreeSet<>();

    private BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    public void Menu() throws IOException {

        int opcion = 0;

        while (opcion != 8) {

            System.out.println("Selecione una opcion");
            System.out.println("1- Agregar Cliente");
            System.out.println("2- Agregar Prestamo");
            System.out.println("3- Imprimir la lista de prestamos con todos sus datos");
            System.out.println("4- Actualizar datos de Prestamo");
            System.out.println("5- Eliminar Prestamos");
            System.out.println("6- Imprimir datos por tipo de prestamo");
            System.out.println("7- Imprimir datos por saldo capital");
            System.out.println("8- Salir");
            System.out.println("Ingrese una opcion:");

            opcion = Integer.parseInt(entrada.readLine());

            switch (opcion) {
                case 1:
                    agregarCliente();
                    break;
                case 2:
                    agregarPrestamo();
                    break;
                case 3:
                    imprimirPrestamos();
                    break;
                case 4:
                    actualizarPrestamo();
                    break;
                case 5:
                    eliminarPrestamos();
                    break;
                case 6:
                    impresionPrestamosPorTipo();
                    break;
                case 7:
                    impresionPrestamosPorSaldo();
                    break;
                case 8:
                    System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }

        }

    }

    private void agregarCliente() throws IOException {
        Cliente nuevoCliente = new Cliente();

        System.out.println("Ingrese numero documento");
        nuevoCliente.setNumeroDocumento(entrada.readLine());

        System.out.println("Ingrese nombre");
        nuevoCliente.setNombre(entrada.readLine());

        System.out.println("Ingrese apellido");
        nuevoCliente.setApellido(entrada.readLine());

        System.out.println("Ingrese edad");
        nuevoCliente.setEdad(Integer.parseInt(entrada.readLine()));

        System.out.println("Ingrese estado civil");
        nuevoCliente.setEstadoCivil(entrada.readLine().charAt(0));

        System.out.println("Ingrese telefono");
        nuevoCliente.setTelefono(Integer.parseInt(entrada.readLine()));

        System.out.println("Ingrese email");
        nuevoCliente.setEmail(entrada.readLine());

        if (listaClientes.add(nuevoCliente)) {
            listaClientesOrdenados.add(nuevoCliente);
            System.out.println("Cliente agregado");
            return;
        } else
            System.err.println("Cliente ya existe");

    }

    private void agregarPrestamo() throws IOException {
        Prestamo nuevoPrestamo = new Prestamo();

        System.out.println("Ingrese numero prestamo");
        nuevoPrestamo.setNumeroPrestamo(Integer.parseInt(entrada.readLine()));

        System.out.println("Ingrese tipo prestamo");
        nuevoPrestamo.setTipoPrestamo(entrada.readLine().charAt(0));

        System.out.println("Ingrese plazo(meses)");
        nuevoPrestamo.setPlazo(Integer.parseInt(entrada.readLine()));

        System.out.println("Ingrese tasa anual");
        nuevoPrestamo.setTasaAnual(Integer.parseInt(entrada.readLine()));

        System.out.println("Ingrese moneda(gs o usd)");
        nuevoPrestamo.setMoneda(entrada.readLine());

        System.out.println("Ingrese monto capital");
        nuevoPrestamo.setMontoCapital(Integer.parseInt(entrada.readLine()));

        System.out.println("Ingrese monto interes");
        nuevoPrestamo.setMontoInteres(Integer.parseInt(entrada.readLine()));

        System.out.println("Ingrese saldo capital");
        nuevoPrestamo.setSaldoCapital(Integer.parseInt(entrada.readLine()));

        System.out.println("Ingrese saldo interes");
        nuevoPrestamo.setSaldoInteres(Integer.parseInt(entrada.readLine()));

        System.out.println("Ingrese cantidad cuotas");
        nuevoPrestamo.setCantidadCuotas(Integer.parseInt(entrada.readLine()));

        System.out.println("Ingrese cuotas pagadas");
        nuevoPrestamo.setCuotasPagadas(Integer.parseInt(entrada.readLine()));

        System.out.println("Ingrese cliente asociado");
        String ci = entrada.readLine();
        for (Cliente elemento : listaClientes) {
            if (ci.equals(elemento.getNumeroDocumento())) {
                nuevoPrestamo.setCliente(elemento);
                if (listaPrestamos.add(nuevoPrestamo)) {
                    listaPrestamosOrdenados.add(nuevoPrestamo);
                    System.out.println("Prestamo agregado");
                    return;
                } else
                    System.err.println("Nro. Prestamo ya existe");
                return;
            }
        }
        System.err.println("Cliente no existe");


    }

    private void imprimirPrestamos() {
        System.out.println("*** LISTA DE PRESTAMOS CON SUS CLIENTES ***");
        for (Prestamo elemento : listaPrestamos) {
            System.out.println("\n\n" + elemento.toString());
            System.out.println("************************************************\n\n");
        }
    }

    private void actualizarPrestamo() throws IOException {
        int numero;
        System.out.println("Ingrese numero de Prestamo:");
        numero = Integer.parseInt(entrada.readLine());
        Iterator<Prestamo> itPrestamo = listaPrestamos.iterator();
        Prestamo prestamoActual = new Prestamo();
        while (itPrestamo.hasNext()) {
            prestamoActual = itPrestamo.next();
            if (prestamoActual.getNumeroPrestamo().intValue() == numero) {
                listaPrestamos.remove(prestamoActual);
                listaPrestamosOrdenados.remove(prestamoActual);

                System.out.println("Ingrese saldo capital:");
                int saldo_c = Integer.parseInt(entrada.readLine());
                while (saldo_c < 0) {
                    System.err.println("Saldo capital menor a 0 :");
                    saldo_c = Integer.parseInt(entrada.readLine());
                }

                System.out.println("Ingrese saldo interes:");
                int saldo_i = Integer.parseInt(entrada.readLine());
                while (saldo_i < 0) {
                    System.err.println("Saldo interes menor a 0 :");
                    saldo_i = Integer.parseInt(entrada.readLine());
                }

                System.out.println("Ingrese Cuotas pagadas:");
                int saldo_cc = Integer.parseInt(entrada.readLine());
                while (saldo_cc < 0) {
                    System.err.println("Cuotas pagadas menor a 0 :");
                    saldo_cc = Integer.parseInt(entrada.readLine());
                }

                if (prestamoActual.getMontoCapital() >= saldo_c && prestamoActual.getMontoInteres() >= saldo_i && prestamoActual.getCantidadCuotas() >= saldo_cc) {
                    prestamoActual.setSaldoCapital(saldo_c);
                    prestamoActual.setSaldoInteres(saldo_i);
                    prestamoActual.setCuotasPagadas(saldo_cc);
                    listaPrestamos.add(prestamoActual);
                    listaPrestamosOrdenados.add(prestamoActual);
                    System.out.println("Prestamo actualizado correctamente");
                    return;
                } else
                    System.err.println("Prestamo no actualizado, datos erroneos o mal cargados");
            }
        }
    }

    private void eliminarPrestamos() throws NumberFormatException, IOException {
        System.out.println("Ingrese numero de documento cliente:");
        String codigoCliente = entrada.readLine();

        boolean resultado = false;
        resultado = listaPrestamos.removeIf(x -> x.getCliente().getNumeroDocumento().equals(codigoCliente));
        listaPrestamosOrdenados.removeIf(y -> y.getCliente().getNumeroDocumento().equals(codigoCliente));
        if (resultado)
            System.out.println("Prestamo eliminado con exito");
        else
            System.out.println("No se encontro prestamo asociado al cliente");
	    /*
		Iterator<Prestamo> itPrestamo = listaPrestamos.iterator();
		    while (itPrestamo.hasNext()) {
		        Prestamo prestamoActual = itPrestamo.next();
		            if (prestamoActual.getCliente().getNumeroDocumento() == codigoCliente) {
		                itPrestamo.remove();
		                listaPrestamosOrdenados.remove(prestamoActual);
		                System.out.println("Prestamo eliminado con exito");
		                return;
		            }
		   }*/
    }

    private void impresionPrestamosPorTipo() {
        System.out.println("*** LISTA ORDENADA POR TIPO***");
        System.out.println("Prestamos de tipo C:");
        for (Prestamo elemento : listaPrestamos) {
            if (elemento.getTipoPrestamo() == 'C') {
                System.out.println(elemento.toString());
            }
        }

        System.out.println("Prestamos de tipo E:");
        for (Prestamo elemento : listaPrestamos) {
            if (elemento.getTipoPrestamo() == 'E') {
                System.out.println(elemento.toString());
            }
        }

        System.out.println("Prestamos de tipo U:");
        for (Prestamo elemento : listaPrestamos) {
            if (elemento.getTipoPrestamo() == 'U') {
                System.out.println(elemento.toString());
            }
        }
        System.out.println("Prestamos de tipo V:");
        for (Prestamo elemento : listaPrestamos) {
            if (elemento.getTipoPrestamo() == 'V') {
                System.out.println(elemento.toString());
            }
        }
    }

    private void impresionPrestamosPorSaldo() {
        System.out.println("*** LISTA ORDENADA POR CAPITAL DESCENDENTEMENTE***");
        listaPrestamosOrdenados.forEach(s -> System.out.println(s.toString()));
			/*for (Prestamo elemento : listaPrestamosOrdenados) {
		           System.out.println(elemento.toString());
		     }*/
    }
}
