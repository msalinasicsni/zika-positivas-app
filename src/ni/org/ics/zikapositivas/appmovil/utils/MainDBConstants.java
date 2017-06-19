/*
 * Copyright (C) 2013 ICS.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package ni.org.ics.zikapositivas.appmovil.utils;



/**
 * Constantes usadas en la base de datos de la aplicacion
 * 
 * @author William Aviles
 * 
 */
public class MainDBConstants {

	//Base de datos y tablas
	public static final String DATABASE_NAME = "zikaposcryp.sqlite3";
	public static final int DATABASE_VERSION = 4;

	//Tabla usuarios
	public static final String USER_TABLE = "users";
	//Campos usuarios
	public static final String username = "username";
	public static final String created = "created";
	public static final String modified = "modified";
	public static final String lastAccess = "lastaccess";
	public static final String password = "password";
	public static final String completeName = "completename";
	public static final String email = "email";
	public static final String enabled = "enabled";
	public static final String accountNonExpired = "accountnonexpired";
	public static final String credentialsNonExpired = "credentialsnonexpired";
	public static final String lastCredentialChange = "lastcredentialchange";
	public static final String accountNonLocked = "accountnonlocked";
	public static final String createdBy = "createdby";
	public static final String modifiedBy = "modifiedby";
	//Crear tabla usuarios
	public static final String CREATE_USER_TABLE = "create table if not exists "
			+ USER_TABLE + " ("
			+ username + " text not null, "  
			+ created + " date, " 
			+ modified + " date, "
			+ lastAccess + " date, "
			+ password + " text not null, "
			+ completeName + " text, "
			+ email + " text, "
			+ enabled  + " boolean, " 
			+ accountNonExpired  + " boolean, "
			+ credentialsNonExpired  + " boolean, "
			+ lastCredentialChange + " date, "
			+ accountNonLocked  + " boolean, "
			+ createdBy + " text, "
			+ modifiedBy + " text, "
			+ "primary key (" + username + "));";
	
	//Tabla roles
	public static final String ROLE_TABLE = "roles";
	//Campos roles
	public static final String role = "role";
	//Crear tabla roles
	public static final String CREATE_ROLE_TABLE = "create table if not exists "
			+ ROLE_TABLE + " ("
			+ username + " text not null, "  
			+ role + " text not null, "
			+ "primary key (" + username + "," + role + "));";
	
	//Campos metadata
	public static final String recordDate = "recordDate";
	public static final String recordUser = "recordUser";
	public static final String pasive = "pasive";
	//Campos comunes para manejo ODK
	public static final String ID_INSTANCIA = "id_instancia";
	public static final String FILE_PATH = "path_instancia";
	public static final String STATUS = "estado";
	//Campos comunes para metadata movil
	public static final String START = "creado";
	public static final String END = "finalizado";
	public static final String DEVICE_ID = "identificador_equipo";
	public static final String SIM_SERIAL = "serie_sim";
	public static final String PHONE_NUMBER = "numero_telefono";
	public static final String TODAY = "fecha_registro";

	
	//Tabla usuarios
	public static final String SCREENING_TABLE = "zp00_screening";
	//Campos usuarios
	public static final String recordId = "recordId";
	public static final String preScreenId = "preScreenId";
	public static final String redcapEventName = "redcapEventName";
	//public static final String numScreening = "numScreening";
	public static final String scrVisitDate = "scrVisitDate";
	public static final String scrRemain = "scrRemain";
	public static final String scrAge = "scrAge";
	public static final String scrAge15 = "scrAge15";
	public static final String scrPregnant = "scrPregnant";
	public static final String scrPreWeeks = "scrPreWeeks";
	public static final String scrPreDays = "scrPreDays";
	public static final String scrPregant13 = "scrPregant13";
	public static final String scrZikaOther = "scrZikaOther";
	public static final String scrMeetCriteria = "scrMeetCriteria";
	public static final String scrConsentObta = "scrConsentObta";
	public static final String scrObDobDay = "scrObDobDay";
	public static final String scrObDobMon = "scrObDobMon";
	public static final String scrObDobYear = "scrObDobYear";
	public static final String scrObAge = "scrObAge";
	public static final String scrObAssent = "scrObAssent";
	public static final String scrConsentA = "scrConsentA";
	public static final String scrConsentB = "scrConsentB";
	public static final String scrConsentC = "scrConsentC";
	public static final String scrConsentD = "scrConsentD";
	public static final String scrConsentE = "scrConsentE";
	public static final String scrConsentF = "scrConsentF";
	public static final String scrAddtConsentG = "scrAddtConsentG";
	public static final String scrPreviousZikaPos = "scrPreviousZikaPos";
	public static final String scrPreviousStudyId = "scrPreviousStudyId";
	public static final String scrPreStudyNa = "scrPreStudyNa";
	public static final String scrReasonNot = "scrReasonNot";
	public static final String scrReasonOther = "scrReasonOther";
	public static final String scrIdCompleting = "scrIdCompleting";
	public static final String scrDateCompleted = "scrDateCompleted";
	public static final String scrIdReviewer = "scrIdReviewer";
	public static final String scrDateReviewed = "scrDateReviewed";
	public static final String scrIdDataEntry = "scrIdDataEntry";
	public static final String scrDateEntered = "scrDateEntered";
	public static final String scrVerbalConsent = "scrVerbalConsent";

	//Crear tabla usuarios
	public static final String CREATE_SCREENING_TABLE = "create table if not exists "
			+ SCREENING_TABLE + " ("
			+ recordId + " text not null, "
			+ preScreenId + " text not null, "
			+ redcapEventName + " text not null, "
			+ scrVisitDate + " date, "
			+ scrVerbalConsent + " text, "
			+ scrRemain + " text, "
			+ scrAge + " integer, "
			+ scrAge15  + " text, " 
			+ scrPregnant + " text, "
			+ scrPreWeeks + " integer, "
			+ scrPreDays + " integer, "
			+ scrPregant13  + " text, " 
			+ scrZikaOther  + " text, " 
			+ scrMeetCriteria  + " text, " 
			+ scrConsentObta  + " text, " 
			+ scrObDobDay + " text, "
			+ scrObDobMon + " text, "
			+ scrObDobYear + " integer, "
			+ scrObAge + " integer, "
			+ scrObAssent + " text, "
			+ scrConsentA + " text, "
			+ scrConsentB + " text, "
			+ scrConsentC + " text, "
			+ scrConsentD + " text, "
			+ scrConsentE + " text, "
			+ scrConsentF + " text, "
			+ scrAddtConsentG + " text, "
			+ scrPreviousZikaPos + " text, "
			+ scrPreviousStudyId + " text, "
			+ scrPreStudyNa  + " text, "
			+ scrReasonNot + " text, "
			+ scrReasonOther + " text, "
			+ scrIdCompleting + " text, "
			+ scrDateCompleted + " date, "
			+ scrIdReviewer + " text, "
			+ scrDateReviewed + " date, "
			+ scrIdDataEntry + " text, "
			+ scrDateEntered + " date, "
			+ recordDate + " date, "
			+ recordUser + " text, "
			+ pasive + " text, "
			+ ID_INSTANCIA + " integer," 
			+ FILE_PATH + " text," 
			+ STATUS + " text not null, "
			+ START  + " text, "
			+ END  + " text, "
			+ DEVICE_ID  + " text, "
			+ SIM_SERIAL + " text, "
			+ PHONE_NUMBER  + " text, "
			+ TODAY  + " date, "
			+ "primary key (" + recordId + "));";
	
		//Tabla estado embarazada
		public static final String STATUS_PREG_TABLE = "estado_embarazada";
		//Campos estado embarazada
		public static final String ingreso = "ingreso";
		public static final String sem2 = "sem2";
		public static final String sem4 = "sem4";
		public static final String sem6 = "sem6";
		public static final String sem8 = "sem8";
		public static final String sem10 = "sem10";
		public static final String sem12 = "sem12";
		public static final String sem14 = "sem14";
		public static final String sem16 = "sem16";
		public static final String sem18 = "sem18";
		public static final String sem20 = "sem20";
		public static final String sem22 = "sem22";
		public static final String sem24 = "sem24";
		public static final String sem26 = "sem26";
		public static final String sem28 = "sem28";
		public static final String sem30 = "sem30";
		public static final String sem32 = "sem32";
		public static final String sem34 = "sem34";
		public static final String sem36 = "sem36";
		public static final String sem38 = "sem38";
		public static final String sem40 = "sem40";
		public static final String sem42 = "sem42";
		public static final String sem44 = "sem44";
		public static final String parto = "parto";
		public static final String posparto = "posparto";
		
		//Crear tabla estado embarazada
		public static final String CREATE_STATUS_PREG_TABLE = "create table if not exists "
				+ STATUS_PREG_TABLE + " ("
				+ recordId + " text not null, "
				+ ingreso + " text, "
				+ sem2 + " text, "
				+ sem4 + " text, "
				+ sem6 + " text, "
				+ sem8 + " text, "
				+ sem10 + " text, "
				+ sem12 + " text, "
				+ sem14 + " text, "
				+ sem16 + " text, "
				+ sem18 + " text, "
				+ sem20 + " text, "
				+ sem22 + " text, "
				+ sem24 + " text, "
				+ sem26 + " text, "
				+ sem28 + " text, "
				+ sem30 + " text, "
				+ sem32 + " text, "
				+ sem34 + " text, "
				+ sem36 + " text, "
				+ sem38 + " text, "
				+ sem40 + " text, "
				+ sem42 + " text, "
				+ sem44 + " text, "
				+ parto + " text, "
				+ posparto + " text, "
				+ recordDate + " date, " 
				+ recordUser + " text, "
				+ pasive + " text, "
				+ ID_INSTANCIA + " integer," 
				+ FILE_PATH + " text," 
				+ STATUS + " text not null, "
				+ START  + " text, "
				+ END  + " text, "
				+ DEVICE_ID  + " text, "
				+ SIM_SERIAL + " text, "
				+ PHONE_NUMBER  + " text, "
				+ TODAY  + " date, "
				+ "primary key (" + recordId + "));";
		
		
		//Tabla datos embarazada
		public static final String DATA_PREG_TABLE = "datos_embarazada";
		//Campos estado embarazada
		public static final String cs = "cs";
		public static final String barrio = "barrio";
		public static final String nombre1 = "nombre1";
		public static final String nombre2 = "nombre2";
		public static final String apellido1 = "apellido1";
		public static final String apellido2 = "apellido2";
		public static final String fechaNac = "fechaNac";
		public static final String direccion = "direccion";
		public static final String latitud = "latitud";
		public static final String longitud = "longitud";
		public static final String telefonoContacto = "telefonoContacto";
		
		//Crear tabla datos embarazada
		public static final String CREATE_DATA_PREG_TABLE = "create table if not exists "
				+ DATA_PREG_TABLE + " ("
				+ recordId + " text not null, "
				+ cs + " text, "
				+ barrio + " text, "
				+ nombre1 + " text, "
				+ nombre2 + " text, "
				+ apellido1 + " text, "
				+ apellido2 + " text, "
				+ fechaNac + " date, "
				+ direccion + " text, "
				+ telefonoContacto + " text, "
				+ latitud + " numeric, "
				+ longitud + " numeric, "
				+ recordDate + " date, " 
				+ recordUser + " text, "
				+ pasive + " text, "
				+ ID_INSTANCIA + " integer," 
				+ FILE_PATH + " text," 
				+ STATUS + " text not null, "
				+ START  + " text, "
				+ END  + " text, "
				+ DEVICE_ID  + " text, "
				+ SIM_SERIAL + " text, "
				+ PHONE_NUMBER  + " text, "
				+ TODAY  + " date, "
				+ "primary key (" + recordId + "));";

		//Tabla datos prescreening
		public static final String DATA_PRESCREEN_TABLE = "datos_prescreening";
		//Campos prescreening
		public static final String recId = "recId";
		public static final String compId = "compId";
		public static final String consecutive = "consecutive";
		public static final String verbalConsent = "verbalConsent";
		
		//Crear tabla prescreening
		public static final String CREATE_DATA_PRESCREEN_TABLE = "create table if not exists "
				+ DATA_PRESCREEN_TABLE + " ("
				+ recId + " text not null, "
				+ cs + " text, "
				+ compId + " text, "
				+ consecutive + " integer, "
				+ verbalConsent + " text, "
				+ recordDate + " date, " 
				+ recordUser + " text, "
				+ pasive + " text, "
				+ ID_INSTANCIA + " integer," 
				+ FILE_PATH + " text," 
				+ STATUS + " text not null, "
				+ START  + " text, "
				+ END  + " text, "
				+ DEVICE_ID  + " text, "
				+ SIM_SERIAL + " text, "
				+ PHONE_NUMBER  + " text, "
				+ TODAY  + " date, "
				+ "primary key (" + recId + "));";	
		
		//Tabla datos salida consentimientos
		public static final String DATA_CONSSAL_TABLE = "salidas_consentimiento";
		//Campos salida consentimientos
		public static final String lugarSalida = "lugarSalida";
		public static final String codigo = "codigo";
		public static final String fechaHoraSalida = "fechaHoraSalida";
		public static final String persona = "persona";
		
		//Crear tabla salida consentimientos
		public static final String CREATE_DATA_CONSSAL_TABLE = "create table if not exists "
				+ DATA_CONSSAL_TABLE + " ("
				+ lugarSalida + " text not null, "
				+ codigo + " text not null, "
				+ fechaHoraSalida + " date not null, " 
				+ persona + " text not null, "
				+ recordDate + " date, " 
				+ recordUser + " text, "
				+ pasive + " text, "
				+ ID_INSTANCIA + " integer," 
				+ FILE_PATH + " text," 
				+ STATUS + " text not null, "
				+ START  + " text, "
				+ END  + " text, "
				+ DEVICE_ID  + " text, "
				+ SIM_SERIAL + " text, "
				+ PHONE_NUMBER  + " text, "
				+ TODAY  + " date, "
				+ "primary key (" + codigo +"));";	
		
		//Tabla datos recepcion consentimientos
		public static final String DATA_CONSREC_TABLE = "recepcion_consentimiento";
		//Campos recepcion consentimientos
		public static final String lugarLlegada = "lugarLlegada";
		public static final String evento = "evento";
		public static final String fechaHoraLLegada = "fechaHoraLLegada";
		public static final String fechaDato = "fechaDato";
		
		//Crear tabla recepcion consentimientos
		public static final String CREATE_DATA_CONSREC_TABLE = "create table if not exists "
				+ DATA_CONSREC_TABLE + " ("
				+ lugarLlegada + " text not null, "
				+ codigo + " text not null, "
				+ fechaHoraLLegada + " date not null, " 
				+ persona + " text not null, "
				+ recordDate + " date, " 
				+ recordUser + " text, "
				+ pasive + " text, "
				+ ID_INSTANCIA + " integer," 
				+ FILE_PATH + " text," 
				+ STATUS + " text not null, "
				+ START  + " text, "
				+ END  + " text, "
				+ DEVICE_ID  + " text, "
				+ SIM_SERIAL + " text, "
				+ PHONE_NUMBER  + " text, "
				+ TODAY  + " date, "
				+ "primary key (" + codigo +"));";
		
		//Tabla datos salida reportes us
		public static final String DATA_USSAL_TABLE = "salidas_us";
		//Campos salida reportes us
		
		//Crear tabla salida reportes us
		public static final String CREATE_DATA_USSAL_TABLE = "create table if not exists "
				+ DATA_USSAL_TABLE + " ("
				+ lugarSalida + " text not null, "
				+ codigo + " text not null, "
				+ fechaHoraSalida + " date not null, " 
				+ persona + " text not null, "
				+ evento + " text, "
				+ fechaDato  + " date, "
				+ recordDate + " date, " 
				+ recordUser + " text, "
				+ pasive + " text, "
				+ ID_INSTANCIA + " integer," 
				+ FILE_PATH + " text," 
				+ STATUS + " text not null, "
				+ START  + " text, "
				+ END  + " text, "
				+ DEVICE_ID  + " text, "
				+ SIM_SERIAL + " text, "
				+ PHONE_NUMBER  + " text, "
				+ TODAY  + " date, "
				+ "primary key (" + codigo + "," + fechaDato +"));";
		
		//Tabla datos recepcion reportes us
		public static final String DATA_USREC_TABLE = "recepcion_us";
		//Campos recepcion reportes us
		
		//Crear tabla recepcion reportes us
		public static final String CREATE_DATA_USREC_TABLE = "create table if not exists "
				+ DATA_USREC_TABLE + " ("
				+ lugarLlegada + " text not null, "
				+ codigo + " text not null, "
				+ fechaHoraLLegada + " date not null, " 
				+ persona + " text not null, "
				+ evento + " text, "
				+ fechaDato  + " date, "
				+ recordDate + " date, " 
				+ recordUser + " text, "
				+ pasive + " text, "
				+ ID_INSTANCIA + " integer," 
				+ FILE_PATH + " text," 
				+ STATUS + " text not null, "
				+ START  + " text, "
				+ END  + " text, "
				+ DEVICE_ID  + " text, "
				+ SIM_SERIAL + " text, "
				+ PHONE_NUMBER  + " text, "
				+ TODAY  + " date, "
				+ "primary key (" + codigo + "," + fechaDato +"));";


		//Tabla ZpInfantData
	    public static String INFANTDATA_TABLE = "zp_datos_infante";

	    public static final String pregnantId = "pregnantId";
	    public static final String infantBirthDate = "infantBirthDate";
	    public static final String infantMode = "infantMode";
	    public static final String infantDeliveryWho = "infantDeliveryWho";
	    public static final String infantDeliveryOccur = "infantDeliveryOccur";
	    public static final String infantHospitalId = "infantHospitalId";
	    public static final String infantClinicId = "infantClinicId";
	    public static final String infantDeliveryOther = "infantDeliveryOther";
	    public static final String infantNumBirth = "infantNumBirth";
	    public static final String infantFetalOutcome = "infantFetalOutcome";
	    public static final String infantCauseDeath = "infantCauseDeath";
	    public static final String infantSexBaby = "infantSexBaby";
	    public static final String infantConsentInfant = "infantConsentInfant";
	    public static final String infantReasonNoconsent = "infantReasonNoconsent";
	    public static final String infantNoconsentOther = "infantNoconsentOther";

	    //Crear tabla ZpInfantData
	    public static final String CREATE_INFANTDATA_TABLE = "create table if not exists "
	            + INFANTDATA_TABLE + " ("
	            + recordId + " text not null, "
	            + pregnantId + " text, "
	            + infantBirthDate + " date, "
	            + infantMode + " text, "
	            + infantDeliveryWho + " text, "
	            + infantDeliveryOccur + " text, "
	            + infantHospitalId + " text, "
	            + infantClinicId + " text, "
	            + infantDeliveryOther + " text, "
	            + infantNumBirth + " text, "
	            + infantFetalOutcome + " text, "
	            + infantCauseDeath + " text, "
	            + infantSexBaby + " text, "
	            + infantConsentInfant + " text, "
	            + infantReasonNoconsent + " text, "
	            + infantNoconsentOther + " text, "
	            + MainDBConstants.recordDate + " date, "
	            + MainDBConstants.recordUser + " text, "
	            + MainDBConstants.pasive + " text, "
	            + MainDBConstants.ID_INSTANCIA + " integer,"
	            + MainDBConstants.FILE_PATH + " text,"
	            + MainDBConstants.STATUS + " text not null, "
	            + MainDBConstants.START  + " text, "
	            + MainDBConstants.END  + " text, "
	            + MainDBConstants.DEVICE_ID  + " text, "
	            + MainDBConstants.SIM_SERIAL + " text, "
	            + MainDBConstants.PHONE_NUMBER  + " text, "
	            + MainDBConstants.TODAY  + " date, "
	            + "primary key (" + recordId + "));";

	    //Tabla ZpInfantData
	    public static String INFANTSTATUS_TABLE = "zp_estado_infante";

	    public static final String nacimiento = "nacimiento";
	    public static final String mes3 = "mes3";
	    public static final String mes6 = "mes6";
	    public static final String mes12 = "mes12";


	    //Crear tabla ZpInfantData
	    public static final String CREATE_INFANTSTATUS_TABLE = "create table if not exists "
	            + INFANTSTATUS_TABLE + " ("
	            + recordId + " text not null, "
	            + nacimiento + " text, "
	            + mes3 + " text, "
	            + mes6 + " text, "
	            + mes12 + " text, "
	            + MainDBConstants.recordDate + " date, "
	            + MainDBConstants.recordUser + " text, "
	            + MainDBConstants.pasive + " text, "
	            + MainDBConstants.ID_INSTANCIA + " integer,"
	            + MainDBConstants.FILE_PATH + " text,"
	            + MainDBConstants.STATUS + " text not null, "
	            + MainDBConstants.START  + " text, "
	            + MainDBConstants.END  + " text, "
	            + MainDBConstants.DEVICE_ID  + " text, "
	            + MainDBConstants.SIM_SERIAL + " text, "
	            + MainDBConstants.PHONE_NUMBER  + " text, "
	            + MainDBConstants.TODAY  + " date, "
	            + "primary key (" + recordId + "));";   
}
