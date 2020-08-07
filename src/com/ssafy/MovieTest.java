package com.ssafy;

import java.util.Scanner;

public class MovieTest {
	static Scanner sc = new Scanner(System.in);
	static MovieMgr movieMgr = MovieMgr.getInstance();

	public static void main(String[] args) {
		
		while (true) {
			printMenu();
			int menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				addMovie();
			} else if (menu == 2) {
				searchAllMovie();
			} else if (menu == 3) {
				searchTitle();
			} else if (menu == 4) {
				searchGenre();
			} else if (menu == 5) {
				delete();
			} else if (menu == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		sc.close();

	}

	private static void searchAllMovie() {
		for (Movie movie : movieMgr.search()) {
			System.out.println(movie);
		}
	}

	public static void printMenu() {
		System.out.println("<<< 영화 관리 프로그램 >>>");
		System.out.println("1. 영화 정보 입력");
		System.out.println("2. 영화 정보 전체 검색");
		System.out.println("3. 영화명 검색");
		System.out.println("4. 영화 장르별 검색");
		System.out.println("5. 영화 정보 삭제");
		System.out.println("0. 종료");
		System.out.println("원하는 번호를 선택하세요.");
	}

	public static void addMovie() {
		System.out.println("영화 정보 입력 상태입니다.");
		System.out.println("영화제목/감독이름/등급(숫자)/장르를 입력해주세요.");
		System.out.println("ex)인셉션/크리스토퍼 놀란/15/스릴러");
		String[] input = sc.nextLine().split("/");
		movieMgr.add(new Movie(input[0], input[1], Integer.parseInt(input[2]), input[3]));
		System.out.println("영화 입력을 성공하였습니다.");
	}

	public static void addPerfectMovie() {
		System.out.println("영화 정보 입력 상태입니다.");
		System.out.println("영화 제목을 입력해주세요.");
		String title = sc.nextLine();
		System.out.println("영화 감독 이름을 입력해주세요.");
		String director = sc.nextLine();
		System.out.println("영화 등급을 입력해주세요(숫자만)");
		int grade = sc.nextInt();
		System.out.println("영화 장르를 입력해주세요.");
		String genre = sc.nextLine();
		System.out.println("영화 요약을 입력해주세요.");
		String summary = sc.nextLine();
		movieMgr.add(new Movie(title, director, grade, genre, summary));
		System.out.println("영화 입력을 성공하였습니다.");
	}

	public static void searchTitle() {
		System.out.println("영화 제목으로 찾기 상태입니다.");
		System.out.println("찾고자하는 제목을 입력해주세요.");
		String title = sc.nextLine();
		Movie[] result = movieMgr.search(title);
		if (result.length >= 1) {
			for (Movie movie : result) {
				System.out.println(movie);
			}
		}else {
			System.out.println("정보가 없습니다.");
		}
	}

	public static void searchDirector() {
		System.out.println("영화 감독명 찾기 상태입니다.");
		System.out.println("찾고자하는 감독을 입력해주세요.");
		String name = sc.nextLine();
		Movie[] result = movieMgr.searchDirector(name);
		for (Movie movie : result) {
			System.out.println(movie);
		}
	}

	public static void searchGenre() {
		System.out.println("영화 장르별 찾기 상태입니다.");
		System.out.println("찾고자하는 장르을 입력해주세요.");
		String genre = sc.nextLine();
		Movie[] result = movieMgr.search(genre);
		for (Movie movie : result) {
			System.out.println(movie);
		}
	}

	public static void delete() {
		System.out.println("영화 삭제 상태입니다.");
		System.out.println("삭제하려는 영화 이름을 입력해주세요.");
		String title = sc.nextLine();
		movieMgr.delete(title);
	}

}
