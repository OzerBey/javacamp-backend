package kodlamaio.northwind.core.utilities.results;

public class SuccessResult extends Result { // default true döner

	public SuccessResult() {
		super(true);
	}

	public SuccessResult(String message) {
		super(true, message);
	}
}
