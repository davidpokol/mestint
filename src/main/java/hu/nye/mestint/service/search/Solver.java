package hu.nye.mestint.service.search;


import java.util.List;


public interface Solver {

	public List<State> solve(State initialState);

}
