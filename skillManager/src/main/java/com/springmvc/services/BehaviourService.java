package com.springmvc.services;

import java.util.List;

import com.springmvc.bo.Behaviour;

public interface BehaviourService extends ISearchService<Behaviour> {

	public void updateBehaviour(Behaviour behaviour);
	public List<Behaviour> listeAllBehaviours();
	public List<Behaviour> listeAllBehaviours(int rowStart, int numberResults);
	public Behaviour createBehaviour(Behaviour behaviour);
	public Behaviour getBehaviour(Long id);
	public void deleteBehaviour(Long id);
	public int behaviourCount();
}
