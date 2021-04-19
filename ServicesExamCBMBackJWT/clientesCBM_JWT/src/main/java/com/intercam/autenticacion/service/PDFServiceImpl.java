/*
 * package com.intercam.autenticacion.service;
 * 
 * import java.awt.Color; import java.awt.Transparency; import
 * java.io.IOException; import java.text.SimpleDateFormat; import
 * java.util.ArrayList; import java.util.HashMap; import java.util.Map;
 * 
 * import javax.swing.border.Border;
 * 
 * import org.springframework.boot.ImageBanner; import
 * org.springframework.data.domain.Page; import
 * org.springframework.stereotype.Service;
 * 
 * import net.sf.jasperreports.engine.JRDataSource; import
 * net.sf.jasperreports.engine.JRException; import
 * net.sf.jasperreports.engine.JasperPrint; import
 * net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
 * 
 * @Service public class PDFServiceImpl implements PDFService {
 * 
 * @Override public JasperPrint getReporteListaPerfiles(List<BancaUsuario>
 * bancaUsuarios) throws IOException, JRException, ClassNotFoundException {
 * 
 * Map<String, String> encabezado = new HashMap<String, String>();
 * 
 * Map<String, String> detalle;
 * 
 * String nivel ;
 * 
 * List<ListaPerfil> listPerfil = new ArrayList<ListaPerfil>();
 * 
 * 
 * for (BancaUsuario bancaUsuario : bancaUsuarios) { detalle = new
 * HashMap<String, String>(); for (Perfil perfil :
 * bancaUsuario.getId().getUsuario().getPerfiles()) { if
 * (!perfil.getPerfNombre().equals("USERBANCA")) { for (PerfilCuenta cuenta :
 * perfil.getCuentas()) { encabezado.put(cuenta.getId().getPbcCuenta(),
 * cuenta.getId().getPbcCuenta()); nivel = new String(); for (PerfilNivel
 * nivelCuenta : perfil.getNiveles()) { if (nivel.equals("")) nivel = new
 * String(" / "); nivel = nivel +
 * nivelCuenta.getId().getNivelFirma().getNfiSigla(); }
 * detalle.put(cuenta.getId().getPbcCuenta(), perfil.getPerfNombre() + nivel); }
 * } } ListaPerfil listaPerfil = new ListaPerfil();
 * listaPerfil.setUsuario(bancaUsuario.getId().getUsuario().getUsuNombre());
 * listaPerfil.setCuentas(new ArrayList<String>(detalle.values()));
 * listPerfil.add(listaPerfil); } ListaPerfil listaPerfil = new ListaPerfil();
 * listaPerfil.setUsuario("encabezado"); listaPerfil.setCuentas(new
 * ArrayList<String>(encabezado.values())); listPerfil.add(listaPerfil);
 * 
 * List<ReporteListaPerfil> list = new ArrayList<ReporteListaPerfil>();
 * 
 * Map<String, Object> params = new HashMap<String, Object>(); List<String>
 * cuentasS = new ArrayList<String>(); List<String> encabezadoL = new
 * ArrayList<String>(); boolean segundoReporte = false;
 * 
 * // el Bean de cuentas tiene 7 campos cuenta, este numero tiene relacion
 * directa con el numero de campos por pagina int cuentasPorPagina = 7; String
 * pattern = "dd MMMMM yyyy HH:mm"; SimpleDateFormat simpleDateFormat =new
 * SimpleDateFormat(pattern); String date = simpleDateFormat.format(new Date());
 * 
 * DynamicReportBuilder drb = new DynamicReportBuilder();
 * 
 * drb .addFirstPageImageBanner("static/assets/images/reportes_logo.png", 197,
 * 60, ImageBanner.Alignment.Left)
 * .addFirstPageImageBanner("static/assets/images/reporte_texto.png", 300, 60,
 * ImageBanner.Alignment.Center) .setTitle( date) .setUseFullPageWidth(true)
 * .setWhenNoDataAllSectionNoDetail()
 * .setPageSizeAndOrientation(Page.Page_Legal_Landscape()); while
 * (!listPerfil.get(0).getCuentas().isEmpty() ) { list =
 * getCollection(listPerfil); if (listPerfil.get(0).getCuentas().size() >
 * cuentasPorPagina) { encabezadoL = new
 * ArrayList<String>(listPerfil.get(0).getCuentas().subList(0,
 * cuentasPorPagina));
 * 
 * } else { encabezadoL = new
 * ArrayList<String>(listPerfil.get(listPerfil.size()-1).getCuentas().subList(0,
 * listPerfil.get(0).getCuentas().size())); }
 * 
 * String dataSourcePath = "DataSource" + cuentasS.size(); DynamicReport dr =
 * creaReporte(list, encabezadoL); JRDataSource dataSource = new
 * JRBeanCollectionDataSource(list); params.put(dataSourcePath, dataSource);
 * 
 * Subreport subreport = new SubReportBuilder()
 * .setStartInNewPage(segundoReporte)
 * .setDataSource(DJConstants.DATA_SOURCE_ORIGIN_PARAMETER,
 * DJConstants.DATA_SOURCE_TYPE_JRDATASOURCE, dataSourcePath)
 * .setDynamicReport(dr, new ClassicLayoutManager()) .build();
 * 
 * segundoReporte = true;
 * 
 * drb.addConcatenatedReport(subreport);
 * 
 * if (listPerfil.get(0).getCuentas().size() < cuentasPorPagina) {
 * listPerfil.get(0).getCuentas().clear(); } else { for (ListaPerfil
 * listaPerfil2 : listPerfil) { List<String> cuentas =
 * listaPerfil2.getCuentas(); cuentasS = new ArrayList<String>(); for (int i =
 * cuentasPorPagina; i < cuentas.size(); i++) { cuentasS.add(cuentas.get(i)); }
 * listaPerfil2.setCuentas(cuentasS); } }
 * 
 * }
 * 
 * JasperPrint jasperPrint =
 * DynamicJasperHelper.generateJasperPrint(drb.build(), new
 * ClassicLayoutManager(), params); return jasperPrint; }
 * 
 * public static List<ReporteListaPerfil> getCollection(List<ListaPerfil> listE)
 * {
 * 
 * List<ReporteListaPerfil> listS = new ArrayList<ReporteListaPerfil>(); //
 * Formato Salida List<String> cuentas; ReporteListaPerfil reporteListaPerfil;
 * 
 * for (int i = 0; i < listE.size()-1; i++) { reporteListaPerfil = new
 * ReporteListaPerfil();
 * reporteListaPerfil.setUsuario(listE.get(i).getUsuario()); cuentas =
 * listE.get(i).getCuentas(); for (int j = 0; j < cuentas.size(); j++) { switch
 * (j) { case 0: reporteListaPerfil.setCuenta1(cuentas.get(j)); break; case 1:
 * reporteListaPerfil.setCuenta2(cuentas.get(j)); break; case 2:
 * reporteListaPerfil.setCuenta3(cuentas.get(j)); break; case 3:
 * reporteListaPerfil.setCuenta4(cuentas.get(j)); break; case 4:
 * reporteListaPerfil.setCuenta5(cuentas.get(j)); break; case 5:
 * reporteListaPerfil.setCuenta6(cuentas.get(j)); break; case 6:
 * reporteListaPerfil.setCuenta7(cuentas.get(j)); break; } }
 * listS.add(reporteListaPerfil); }
 * 
 * return listS; } public static DynamicReport
 * creaReporte(List<ReporteListaPerfil> list, List<String> encabezado ) throws
 * ColumnBuilderException, ClassNotFoundException {
 * 
 * Style headerStyle = new Style(); headerStyle.setFont(Font.ARIAL_MEDIUM);
 * headerStyle.setBorderBottom(Border.PEN_2_POINT());
 * headerStyle.setHorizontalAlign(HorizontalAlign.LEFT);
 * headerStyle.setVerticalAlign(VerticalAlign.MIDDLE);
 * headerStyle.setBackgroundColor(Color.LIGHT_GRAY);
 * headerStyle.setTextColor(Color.BLACK);
 * headerStyle.setTransparency(Transparency.OPAQUE); // FastReportBuilder drb =
 * new FastReportBuilder(); DynamicReportBuilder drb = new
 * DynamicReportBuilder(); AbstractColumn column =
 * ColumnBuilder.getNew().setColumnProperty("usuario", String.class.getName())
 * .setTitle("Usuario/Cuentas/Perfil").setWidth(new Integer(100))
 * .setHeaderStyle(headerStyle).build(); drb.addColumn(column); //
 * drb.addColumn("Usuario/Cuentas/Perfil", "usuario", String.class.getName(),
 * 100);
 * 
 * // AbstractColumn columnState =
 * ColumnBuilder.getNew().setColumnProperty("usuario", String.class.getName())
 * // .setTitle("State").setWidth(new Integer(85)) //
 * .setStyle(headerStyle).setHeaderStyle(headerStyle).build(); switch
 * (encabezado.size()) { case 1: column =
 * ColumnBuilder.getNew().setColumnProperty("cuenta1", String.class.getName())
 * .setTitle(encabezado.get(0)).setWidth(new
 * Integer(50)).setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * break; case 2: column = ColumnBuilder.getNew().setColumnProperty("cuenta1",
 * String.class.getName()) .setTitle(encabezado.get(0)).setWidth(new
 * Integer(50)).setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * column = ColumnBuilder.getNew().setColumnProperty("cuenta2",
 * String.class.getName()) .setTitle(encabezado.get(1)).setWidth(new
 * Integer(50)) .setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * break; case 3: column = ColumnBuilder.getNew().setColumnProperty("cuenta1",
 * String.class.getName()) .setTitle(encabezado.get(0)).setWidth(new
 * Integer(50)) .setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * column = ColumnBuilder.getNew().setColumnProperty("cuenta2",
 * String.class.getName()) .setTitle(encabezado.get(1)).setWidth(new
 * Integer(50)) .setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * column = ColumnBuilder.getNew().setColumnProperty("cuenta3",
 * String.class.getName()) .setTitle(encabezado.get(2)).setWidth(new
 * Integer(50)) .setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * break; case 4: column = ColumnBuilder.getNew().setColumnProperty("cuenta1",
 * String.class.getName()) .setTitle(encabezado.get(0)).setWidth(new
 * Integer(50)) .setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * column = ColumnBuilder.getNew().setColumnProperty("cuenta2",
 * String.class.getName()) .setTitle(encabezado.get(1)).setWidth(new
 * Integer(50)) .setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * column = ColumnBuilder.getNew().setColumnProperty("cuenta3",
 * String.class.getName()) .setTitle(encabezado.get(2)).setWidth(new
 * Integer(50)) .setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * column = ColumnBuilder.getNew().setColumnProperty("cuenta4",
 * String.class.getName()) .setTitle(encabezado.get(3)).setWidth(new
 * Integer(50)) .setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * break; case 5: column = ColumnBuilder.getNew().setColumnProperty("cuenta1",
 * String.class.getName()) .setTitle(encabezado.get(0)).setWidth(new
 * Integer(50)) .setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * column = ColumnBuilder.getNew().setColumnProperty("cuenta2",
 * String.class.getName()) .setTitle(encabezado.get(1)).setWidth(new
 * Integer(50)) .setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * column = ColumnBuilder.getNew().setColumnProperty("cuenta3",
 * String.class.getName()) .setTitle(encabezado.get(2)).setWidth(new
 * Integer(50)) .setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * column = ColumnBuilder.getNew().setColumnProperty("cuenta4",
 * String.class.getName()) .setTitle(encabezado.get(3)).setWidth(new
 * Integer(50)) .setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * column = ColumnBuilder.getNew().setColumnProperty("cuenta5",
 * String.class.getName()) .setTitle(encabezado.get(4)).setWidth(new
 * Integer(50)) .setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * break; case 6: column = ColumnBuilder.getNew().setColumnProperty("cuenta1",
 * String.class.getName()) .setTitle(encabezado.get(0)).setWidth(new
 * Integer(50)) .setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * column = ColumnBuilder.getNew().setColumnProperty("cuenta2",
 * String.class.getName()) .setTitle(encabezado.get(1)).setWidth(new
 * Integer(50)) .setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * column = ColumnBuilder.getNew().setColumnProperty("cuenta3",
 * String.class.getName()) .setTitle(encabezado.get(2)).setWidth(new
 * Integer(50)) .setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * column = ColumnBuilder.getNew().setColumnProperty("cuenta4",
 * String.class.getName()) .setTitle(encabezado.get(3)).setWidth(new
 * Integer(50)) .setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * column = ColumnBuilder.getNew().setColumnProperty("cuenta5",
 * String.class.getName()) .setTitle(encabezado.get(4)).setWidth(new
 * Integer(50)) .setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * column = ColumnBuilder.getNew().setColumnProperty("cuenta6",
 * String.class.getName()) .setTitle(encabezado.get(5)).setWidth(new
 * Integer(50)) .setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * break; case 7: column = ColumnBuilder.getNew().setColumnProperty("cuenta1",
 * String.class.getName()) .setTitle(encabezado.get(0)).setWidth(new
 * Integer(50)) .setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * column = ColumnBuilder.getNew().setColumnProperty("cuenta2",
 * String.class.getName()) .setTitle(encabezado.get(1)).setWidth(new
 * Integer(50)) .setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * column = ColumnBuilder.getNew().setColumnProperty("cuenta3",
 * String.class.getName()) .setTitle(encabezado.get(2)).setWidth(new
 * Integer(50)) .setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * column = ColumnBuilder.getNew().setColumnProperty("cuenta4",
 * String.class.getName()) .setTitle(encabezado.get(3)).setWidth(new
 * Integer(50)) .setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * column = ColumnBuilder.getNew().setColumnProperty("cuenta5",
 * String.class.getName()) .setTitle(encabezado.get(4)).setWidth(new
 * Integer(50)) .setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * column = ColumnBuilder.getNew().setColumnProperty("cuenta6",
 * String.class.getName()) .setTitle(encabezado.get(5)).setWidth(new
 * Integer(50)) .setHeaderStyle(headerStyle).build(); drb.addColumn(column);
 * column = ColumnBuilder.getNew().setColumnProperty("cuenta7",
 * String.class.getName()) .setTitle(encabezado.get(6)).setWidth(new
 * Integer(50)) .setHeaderStyle(headerStyle).build(); drb.addColumn(column); }
 * 
 * DynamicReport dr = drb.setUseFullPageWidth(true).build(); return dr; }
 * 
 * }
 */