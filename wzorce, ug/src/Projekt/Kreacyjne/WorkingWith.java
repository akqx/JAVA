package Projekt.Kreacyjne;

import java.util.ArrayList;
import java.util.List;

public class WorkingWith {
	List<Perfume> perfumsAttualWork = new ArrayList<Perfume>();

	// Singelton -> tylko firmy wpó³pracuj¹ce mog¹ byæ w sklepie
	CompanySingelton company = CompanySingelton.getInstance();

	public  void add(Perfume perfume) {
		for (String i : company.getWorkingWith()) {
			if (perfume.getName() == i) {
				perfumsAttualWork.add(perfume);
			}
		}
	}
	
	public List<Perfume> getPerfumList(){
		return perfumsAttualWork;
	}
}
