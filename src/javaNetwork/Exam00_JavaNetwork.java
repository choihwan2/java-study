package javaNetwork;

/*
 * network : 유선, 무선을 이용해서 데이터 통신을 하기 위해
 *           컴퓨터를 논리적, 물리적으로 묶어놓은 형태
 *           
 * network의 형태 - 크기에 따라서 여러가지 형태로 구분
 * 1. LAN(Local Area Network)
 * 2. WAN(Wide Area Network)  
 * 3. MAN(Metropolitan Area Network)
 * 
 * Internet : Network of Network
 *            물리적인 네트워크의 형태 
 * Internet을 사용하기 위해서는 그 위에서 동작하는 Service가
 * 있어야 해요!
 * 가장 대표적인 서비스 : Web, EMAIL, Torrent, Streaming
 *                  ...
 *           
 * Internet 위에서 각각의 서비스가 동작하려면 각 컴퓨터들이 서로를
 * 인지할 수 있는 수단이 필요!                                  
 * 각 컴퓨터마다 주소를 부여할 필요가 있어요!
 * 컴퓨터가 아니라 컴퓨터부품중에 NIC(Network Interface Card)
 * 우리가 일반적으로 LAN카드라고 불러요! 이 LAN카드에 IP Address를 부여   
 * IPv4 => xxx.xxx.xxx.xxx 초창기에 사용했어요. 초기에는 문제없이 사용했어요!
 * 시간이 지나면서 점점 주소가 모자라게 되요! => IPv6가 나왔어요!
 *                                 
 * IP Address => LAN카드에 부여된 논리적인 주소. 하지만 논리적인 주소만으로는
 * 당연히 컴퓨터간의 통신을 할 수 없어요! 물리적인 주소가 있어야 통신을 할 수 있어요!\
 * 이 물리적인 주소를 => MAC Address
 * ===> IP Address를 이용해서 특정 컴퓨터를 찾을 수 있어요!!
 * ===> IP Address는 숫자라서 기억하기가 쉽지 않아요! => 
 * DNS(Domain Name System)를 도입해요. => www.naver.com
 * 
 * IP Address를 알아야 통신하고자 하는 상대방 컴퓨터를 인지할 수 있어요!
 * 통신을 하려면 => Protocol이 필요해요!
 * TCP, IP ,ARP, TELNET, FTP, ...HTTP
 * 
 * Port라는 개념 : 숫자 0~ 65535 범위를 가지는 숫자 0~1023번까지는 예약되어 있어요!
 * 컴퓨터 내에 동작하고 있는 프로그램을 지칭하는 숫자.
 * 
 * 결론적으로 한 컴퓨터와 다른 컴퓨터가 데이터를 주고 받으려면
 * 1. protocol을 알아야 해요!
 * 2. IP Address를 알아야 해요!
 * 3. Port번호를 알아야 해요!
 * 
 *  네트워크 프로그램이 너무 어려워요!!
 *  Socket이라는 개념을 만들었어요! Socket을 만들면 복잡한 네트워크 처리를
 *  Socket이 대신 알아서 처리하도록 그렇게 만들었어요!
 *                                 
 *  Java NEtwork 프로그램은 CS구조를 가져요!(Client Server구조)
 *                                  
 */
public class Exam00_JavaNetwork {

}
