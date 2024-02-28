package com.idace.helpdesk.services;

import com.idace.helpdesk.domain.enums.Perfil;
import com.idace.helpdesk.domain.enums.Prioridade;
import com.idace.helpdesk.domain.enums.Status;
import com.idace.helpdesk.domain.enums.domain.Chamado;
import com.idace.helpdesk.domain.enums.domain.Cliente;
import com.idace.helpdesk.domain.enums.domain.Tecnico;
import com.idace.helpdesk.repositories.ChamadoRepository;
import com.idace.helpdesk.repositories.ClienteRepository;
import com.idace.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public void instanciaDB() {
//        Tecnico tec1 = new Tecnico(null, "Marcos Albano", "41622995368", "marcos.telematica@gmail.com", encoder.encode("Albano@1971"));
//        tec1.addPerfil(Perfil.ADMIN);
//        tec1.addPerfil(Perfil.TECNICO);
//        Tecnico tec2 = new Tecnico(null, "Marcos Souza", "741.511.263-68", "mvfelix2011@hotmail.com", encoder.encode("123456"));
//        tec2.addPerfil(Perfil.TECNICO);
//        Tecnico tec3 = new Tecnico(null, "Raimundo Nonato", "300.895.223-20", "raimundo.nonato@idace.ce.gov.brm", encoder.encode("123456"));
//        tec3.addPerfil(Perfil.TECNICO);
//
//        Cliente	cli1	=	new Cliente(	null,	"AGENOR FILHO"	,	"00434478300"	,	"agenor.filho@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli2	=	new Cliente(	null,	"ALANNA PINHO"	,	"02614630390"	,	"alanna.pinho@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli3	=	new Cliente(	null,	"ALEXANDRE MAGNUM LEORNE PONTES"	,	"95100008334"	,	"alexandreleorne@topodatum.com.br"	,	encoder.encode("123456"));
//        Cliente	cli4	=	new Cliente(	null,	"AMANDA ALVES MESQUITA"	,	"06246378323"	,	"amanda.alves@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli5	=	new Cliente(	null,	"AMARILDO AQUINO"	,	"24370355320"	,	"amarildo.aquino@hotmail.com"	,	encoder.encode("123456"));
//        Cliente	cli6	=	new Cliente(	null,	"ANA CLARA"	,	"02676289357"	,	"ana.clara@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli7	=	new Cliente(	null,	"ANA CLEIDE ALVES FERREIRA"	,	"40859916391"	,	"anasara19@gmail.com"	,	encoder.encode("123456"));
//        Cliente	cli8	=	new Cliente(	null,	"ANNE SANTOS"	,	"08790318323"	,	"anysantosgaby@gmail.com"	,	encoder.encode("123456"));
//        Cliente	cli9	=	new Cliente(	null,	"ANTONIA JEANE BRAGA DE FARIAS"	,	"06683807302"	,	"antonia.farias@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli10	=	new Cliente(	null,	"ANTONIA LOPES PINHO"	,	"73216178315"	,	"antonia.lopes@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli11	=	new Cliente(	null,	"ANTONIO ERIVANDO BEZERRA"	,	"01234236354"	,	"antonio.bezerra@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli12	=	new Cliente(	null,	"ANTÔNIO AMORIM"	,	"16349644387"	,	"antonio.amorim@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli13	=	new Cliente(	null,	"ANTONIO AURELIANO MOREIRA GOMES"	,	"02555818316"	,	"aureliano@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli14	=	new Cliente(	null,	"ANTONIO EDVAR PERES MARTINS"	,	"06059473334"	,	"antonioedvar56@hotmail.com"	,	encoder.encode("123456"));
//        Cliente	cli15	=	new Cliente(	null,	"BRENDA MOURÃO"	,	"08059400304"	,	"brenda.rmouraorocha@gmail.com"	,	encoder.encode("123456"));
//        Cliente	cli16	=	new Cliente(	null,	"CARINE PEIXOTO"	,	"67198341349"	,	"carinepfelicio@gmail.com"	,	encoder.encode("123456"));
//        Cliente	cli17	=	new Cliente(	null,	"CARLOS CÉSAR COLARES DE FREITAS"	,	"24447692368"	,	"colares@cruzerocha.com.br"	,	encoder.encode("123456"));
//        Cliente	cli18	=	new Cliente(	null,	"CELIANNE MATOS"	,	"04692413301"	,	"celimatos@gmail.com"	,	encoder.encode("123456"));
//        Cliente	cli19	=	new Cliente(	null,	"CHICO ALVES"	,	"20267800304"	,	"chicoalves1960@hotmail.com"	,	encoder.encode("123456"));
//        Cliente	cli20	=	new Cliente(	null,	"CLAUDIA ROCHA"	,	"71986693368"	,	"claudia.rocha@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli21	=	new Cliente(	null,	"CRISTIANO GONÇALVES"	,	"05173843373"	,	"cristiano.goncalves@idace.gov.ce.br"	,	encoder.encode("123456"));
//        Cliente	cli22	=	new Cliente(	null,	"CYNARA DAMASCENO"	,	"38899922349"	,	"cynara.damasceno@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli23	=	new Cliente(	null,	"DANIELLY AZEVEDO"	,	"02621587364"	,	"danielly.azevedo@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli24	=	new Cliente(	null,	"DAYANA CAVALCANTE"	,	"61370257309"	,	"yanacavalcante2014@gmail.com"	,	encoder.encode("123456"));
//        Cliente	cli25	=	new Cliente(	null,	"DHEURY OLIVEIRA"	,	"02708774360"	,	"dheury.oliveira@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli26	=	new Cliente(	null,	"DINAELLY MASCARENHAS"	,	"02621408370"	,	"dinaelly.mascarenhas@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli27	=	new Cliente(	null,	"EFIGÊNIA OLIVEIRA"	,	"61946702315"	,	"piresefigenia226@gmail.com"	,	encoder.encode("123456"));
//        Cliente	cli28	=	new Cliente(	null,	"ELAINE BARROS"	,	"05707685197"	,	"elainedvb97@gmail.com"	,	encoder.encode("123456"));
//        Cliente	cli29	=	new Cliente(	null,	"ELIANE BEZERRA"	,	"38835932300"	,	"eliane.bezerra@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli30	=	new Cliente(	null,	"EMANOEL RODRIGUES"	,	"04277331386"	,	"emanoel.rodrigues@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli31	=	new Cliente(	null,	"EREMITA SILVA"	,	"68833504387"	,	"eremita.silva@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli32	=	new Cliente(	null,	"EUDA MARIA"	,	"93562985304"	,	"euda81@hotmail.com"	,	encoder.encode("123456"));
//        Cliente	cli33	=	new Cliente(	null,	"FELIPE TOMÉ"	,	"04185779356"	,	"felipe.tome@idace.gov.ce.br"	,	encoder.encode("123456"));
//        Cliente	cli34	=	new Cliente(	null,	"FÉLIX JÚNIOR"	,	"03569744302"	,	"felix.junior@gmail.com"	,	encoder.encode("123456"));
//        Cliente	cli35	=	new Cliente(	null,	"FILIPE ANTUNES COSTA"	,	"10971609713"	,	"filipe@cosampa.com.br"	,	encoder.encode("123456"));
//        Cliente	cli36	=	new Cliente(	null,	"FRANCISCA ERICA JERONIMO DA SILVA"	,	"00607461306"	,	"erikinhajsilva@hotmail.com"	,	encoder.encode("123456"));
//        Cliente	cli37	=	new Cliente(	null,	"FRANCISCA LUZINEIDE"	,	"21343322391"	,	"francisca.luzineide@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli38	=	new Cliente(	null,	"FRANCISCO ERIDAN"	,	"20862148391"	,	"eridanp@outlook.com"	,	encoder.encode("123456"));
//        Cliente	cli39	=	new Cliente(	null,	"FRANCISCO VIANCI DA SILVA"	,	"09314695387"	,	"francisco@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli40	=	new Cliente(	null,	"FRANCISCO SILVEIRA"	,	"00770748317"	,	"aytallo@gmail.com"	,	encoder.encode("123456"));
//        Cliente	cli41	=	new Cliente(	null,	"FRANCISCO ROGÉRIO"	,	"17129648368"	,	"rogeriocmota.8913@gmail.com"	,	encoder.encode("123456"));
//        Cliente	cli42	=	new Cliente(	null,	"FRANCISCO OSVALDO ARAÚJO MADUREIRA"	,	"14151499334"	,	"osvaldo.madureira@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli43	=	new Cliente(	null,	"GERMANA RODRIGUES"	,	"67193277391"	,	"germana.castro.rodrigues@gmail.com"	,	encoder.encode("123456"));
//        Cliente	cli44	=	new Cliente(	null,	"GRACINHA PEDROSA"	,	"16984293391"	,	"gracinha.pedrosa@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli45	=	new Cliente(	null,	"GUILHERME BRASIL"	,	"08163081368"	,	"gulhermebrasil1964@yahoo.com"	,	encoder.encode("123456"));
//        Cliente	cli46	=	new Cliente(	null,	"HARLLEY COSTA"	,	"08476869304"	,	"harlley.costa@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli47	=	new Cliente(	null,	"IAN ANDRADE"	,	"06736199158"	,	"iam.indrade@idace.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli48	=	new Cliente(	null,	"JESUINO LIMA"	,	"96598603315"	,	"jesuino.lima@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli49	=	new Cliente(	null,	"JOAO MELO"	,	"13633740368"	,	"joao.melo@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli50	=	new Cliente(	null,	"JOAO VITOR RIBEIRO"	,	"61704678358"	,	"joao.vibeiro@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli51	=	new Cliente(	null,	"JOAQUIM PACÍFICO SOARES DE MACÊDO"	,	"26714337353"	,	"joaquim.pacifico@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli52	=	new Cliente(	null,	"JOEL MARGALHAES"	,	"00724322337"	,	"joel.margalhaes@idace.com"	,	encoder.encode("123456"));
//        Cliente	cli53	=	new Cliente(	null,	"JONAS SILVA"	,	"75515172353"	,	"jonas@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli54	=	new Cliente(	null,	"JORGE PINTO"	,	"42617162320"	,	"manoel.franca@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli55	=	new Cliente(	null,	"JOSE  WALACY"	,	"72691956334"	,	"jose.walacy@idace.ce.gob.br"	,	encoder.encode("123456"));
//        Cliente	cli56	=	new Cliente(	null,	"JOSÉ DAVI ANSELMO DA SILVA"	,	"61731924380"	,	"DAVYYSILVA2000@GMAIL.COM"	,	encoder.encode("123456"));
//        Cliente	cli57	=	new Cliente(	null,	"JOSEMÁRIA PINHO"	,	"04292718326"	,	"josemaria.pinho@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli58	=	new Cliente(	null,	"JULIANA LEITE"	,	"67208614334"	,	"juliana.leite@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli59	=	new Cliente(	null,	"KACILDA COELHO PEREIRA"	,	"77437195372"	,	"kacilda@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli60	=	new Cliente(	null,	"KEDMA ARRUDA"	,	"00712619313"	,	"kedmaematerce@hotmail.com"	,	encoder.encode("123456"));
//        Cliente	cli61	=	new Cliente(	null,	"LETÍCIA OLIVEIRA"	,	"07633865377"	,	"LETTICIA.OLLVEIRA@OUTLOOK.COM"	,	encoder.encode("123456"));
//        Cliente	cli62	=	new Cliente(	null,	"LINARDY BARRETO DE HOLANDA"	,	"89359402320"	,	"barreto@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli63	=	new Cliente(	null,	"LUCAS ALMEIDA"	,	"61508953350"	,	"lucas.almeida@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli64	=	new Cliente(	null,	"LUCIANA LOPES"	,	"03785062346"	,	"luciana.lopes@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli65	=	new Cliente(	null,	"LUCIANO SILVA"	,	"45711798391"	,	"luciano.silva@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli66	=	new Cliente(	null,	"MARCIA OLIVEIRA"	,	"96273798320"	,	"marcia.oliveira@idace.ce.gov.br"	,	encoder.encode("123456"));
//        //Cliente	cli67	=	new Cliente(	null,	"MARCOS SILVA"	,	"41622995368"	,	"marcos.silva@idace.ce.gov.br"	,	encoder.encode("123456"));
//        //Cliente	cli68	=	new Cliente(	null,	"MARCOS SOUSA"	,	"74151126368"	,	"mvfelix2011@hotmail.com"	,	encoder.encode("123456"));
//        Cliente	cli69	=	new Cliente(	null,	"MARIA  MARGARETE"	,	"22215344334"	,	"maria.margarete@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli70	=	new Cliente(	null,	"MARIA ALBANIZA SANTIAGO LIMA ALVES"	,	"46922776372"	,	"maria.albaniza@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli71	=	new Cliente(	null,	"MARIA DAS GRAÇAS  ANDRADE NOGUEIRA "	,	"76172902334"	,	"maria@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli72	=	new Cliente(	null,	"MARIANO ALVES"	,	"60869422340"	,	"mariano@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli73	=	new Cliente(	null,	"MATEUS SILVA"	,	"62071570367"	,	"mateus.silva@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli74	=	new Cliente(	null,	"MEYRELENE GADELHA"	,	"03085170324"	,	"meyrelene.gadelha@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli75	=	new Cliente(	null,	"MIRNA SAMPAIO"	,	"03737525390"	,	"mirna.mourao@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli76	=	new Cliente(	null,	"NADIR LOIOLA DIAS"	,	"11627247300"	,	"nadir.loiola@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli77	=	new Cliente(	null,	"PAULO HENRIQUE MAGALHÃES LOBO"	,	"11162180382"	,	"paulo.lobo@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli78	=	new Cliente(	null,	"PRISCILLA AZEVEDO DE AGUIAR"	,	"01820057399"	,	"priscilla.azevedo@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli79	=	new Cliente(	null,	"RAIMUNDO BRILHANTE"	,	"21942811349"	,	"raimundo.brilhante@idace.ce.gov.br"	,	encoder.encode("123456"));
//       // Cliente	cli80	=	new Cliente(	null,	"RAIMUNDO NONATO"	,	"30089522320"	,	"raimundo.nonato@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli81	=	new Cliente(	null,	"RAIMUNDO FRUTUOSO"	,	"03503735313"	,	"raimundo.frutuoso@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli82	=	new Cliente(	null,	"RENATO MARIANO"	,	"61573965391"	,	"renato.mariano@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli83	=	new Cliente(	null,	"RENÊ  MATEUS"	,	"61393686346"	,	"rene.mateus@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli84	=	new Cliente(	null,	"RONALDO CEZAR"	,	"11288710330"	,	"ronafort@hotmail.com"	,	encoder.encode("123456"));
//        Cliente	cli85	=	new Cliente(	null,	"SANDRA DE CASTRO FORTE"	,	"82142866387"	,	"sanforte@gmail.com"	,	encoder.encode("123456"));
//        Cliente	cli86	=	new Cliente(	null,	"SANDRO FACUNDES BONFIM"	,	"25988395368"	,	"sfbonfim@yahoo.com.br"	,	encoder.encode("123456"));
//        Cliente	cli87	=	new Cliente(	null,	"SANTIAGO ESTEVES"	,	"62133165312"	,	"santiago@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli88	=	new Cliente(	null,	"SARA"	,	"66410746334"	,	"sara@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli89	=	new Cliente(	null,	"SERGIAN VALÉRIO"	,	"85253880330"	,	"sergian.valerio@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli90	=	new Cliente(	null,	"SILVIA  HELENA"	,	"23603100387"	,	"silvia.helena@idace.goc.br"	,	encoder.encode("123456"));
//        Cliente	cli91	=	new Cliente(	null,	"TEREZINHA RODRIGUES"	,	"47210176349"	,	"terezinha.rodrigues@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli92	=	new Cliente(	null,	"TIAGO DINIZ"	,	"60456672397"	,	"tiago.diniz@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli93	=	new Cliente(	null,	"UBIRAJARA SCARCELA"	,	"31018300368"	,	"ubirajarascarcela@gmail.com "	,	encoder.encode("123456"));
//        Cliente	cli94	=	new Cliente(	null,	"VALMIR CARLOS"	,	"19061714320"	,	"valmir.carlos@idace.ce.gov.br"	,	encoder.encode("123456"));
//        Cliente	cli95	=	new Cliente(	null,	"VARDELAN NOBRE"	,	"19510896349"	,	"nobre.vardelan@bol.com.br"	,	encoder.encode("123456"));
//        Cliente	cli96	=	new Cliente(	null,	"VILAZIO LUCAS"	,	"49119222300"	,	"vilazio.lucas@idace.ce.gov.br"	,	encoder.encode("123456"));
//
//        tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3));
//        clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3,cli4,cli5,cli6,cli7,cli8,cli9,cli10,cli11,cli12,cli13,cli14,cli15,cli16,cli17,cli18,cli19,cli20,cli21,cli22,cli23,cli24,cli25,cli26,cli27,cli28,cli29,cli30,cli31,cli32,cli33,cli34,cli35,cli36,cli37,cli38,cli39,cli40,cli41,cli42,cli43,cli44,cli45,cli46,cli47,cli48,cli49,cli50,cli51,cli52,cli53,cli54,cli55,cli56,cli57,cli58,cli59,cli60,cli61,cli62,cli63,cli64,cli65,cli66,cli69,cli70,cli71,cli72,cli73,cli74,cli75,cli76,cli77,cli78,cli79,cli81,cli82,cli83,cli84,cli85,cli86,cli87,cli88,cli89,cli90,cli91,cli92,cli93,cli94,cli95,cli96));
    }
}
