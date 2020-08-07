package com.ssafy;

public class MovieMgr {
	private static MovieMgr mv;
	private Movie[] movies = new Movie[100];
	private int index = 0;

	private MovieMgr() {

	}

	public static MovieMgr getInstance() {
		if (mv == null) {
			mv = new MovieMgr();
		}
		return mv;
	}

	public void add(Movie m) {
		if (index >= 0 && index < 99) {
			movies[index++] = m;
		} else {
			System.out.println("영화가 가득차있습니다.. 지워주셔야 합니다 도르륵..");
		}
	}

	public Movie[] search() {
		Movie[] allMovie = new Movie[index];
		for (int i = 0; i < index; i++) {
			allMovie[i] = movies[i];
		}
		return allMovie;
	}

	public Movie[] search(String title) {
		int len = 0;
		int dirIndex = 0;
		for (int i = 0; i < index; i++) {
			if (movies[i].getTitle().equals(title)) {
				len++;
			}
		}
		Movie[] searchMovies = new Movie[len];
		for (int i = 0; i < index; i++) {
			if (movies[i].getTitle().equals(title)) {
				searchMovies[dirIndex++] = movies[i];
			}
		}
		return searchMovies;
	}

	public Movie[] searchDirector(String name) {
		int len = 0;
		int dirIndex = 0;
		for (int i = 0; i < index; i++) {
			if (movies[i].getDirector().equals(name)) {
				len++;
			}
		}
		Movie[] dirMovies = new Movie[len];
		for (int i = 0; i < index; i++) {
			if (movies[i].getDirector().equals(name)) {
				dirMovies[dirIndex++] = movies[i];
			}
		}
		return dirMovies;
	}

	public Movie[] searchGenre(String genre) {
		int len = 0;
		int genIndex = 0;
		for (int i = 0; i < index; i++) {
			if (movies[i].getGenre().equals(genre)) {
				len++;
			}
		}
		Movie[] genMovies = new Movie[len];
		for (int i = 0; i < index; i++) {
			if (movies[i].getGenre().equals(genre)) {
				genMovies[genIndex++] = movies[i];
			}
		}
		return genMovies;
	}

	public void delete(String title) {
		for (int i = 0; i < index; i++) {
			if (movies[i].getTitle().equals(title)) {
				System.arraycopy(movies, i + 1, movies, i, 100 - i - 1);
				index--;
				i--;
			}
		}
	}

	public int getSize() {
		return index;
	}

}
