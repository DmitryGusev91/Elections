package id316923200;
//NAME: Dmitry Gusev
//ID:316923200
public interface Candidatable {// Forces to ask the question if the person is a candidate and what is the name
								// of the party he is candidate for
	boolean isACandidate(boolean running);

	boolean setPartyName(String name);
}
