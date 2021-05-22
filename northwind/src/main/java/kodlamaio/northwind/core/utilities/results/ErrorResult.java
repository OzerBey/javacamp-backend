package kodlamaio.northwind.core.utilities.results;

public class ErrorResult extends Result { // default false döner 

	public ErrorResult() {
		super(false);
	}

	public ErrorResult(String message) {
		super(false, message);
	}

}
