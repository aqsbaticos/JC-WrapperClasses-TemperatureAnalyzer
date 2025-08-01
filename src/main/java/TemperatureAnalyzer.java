import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TemperatureAnalyzer {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		String day1TempStr, day2TempStr, day3TempStr;
		double day1TempPrimitive, day2TempPrimitive, day3TempPrimitive;

		System.out.println("\n--- PROGRAM START ---");

		//	PART 1: USER INPUT & STRING PARSING
		System.out.print("Enter Day 1 High Temperature (e.g., 25.7): ");
		day1TempStr = in.next();
		try {
			day1TempPrimitive = Double.parseDouble(day1TempStr);
		} catch (NumberFormatException e) {
			System.out.println("You entered an invalid number. Value defaulted to 0.");
			day1TempPrimitive = 0.0;
		}

		System.out.print("Enter Day 2 High Temperature (e.g., 30.5): ");
		day2TempStr = in.next();
		try {
			day2TempPrimitive = Double.parseDouble(day2TempStr);
		} catch (NumberFormatException e) {
			System.out.println("You entered an invalid number. Value defaulted to 0.");
			day2TempPrimitive = 0.0;
		}

		System.out.print("Enter Day 3 High Temperature (e.g., 28.1): ");
		day3TempStr = in.next();
		try {
			day3TempPrimitive = Double.parseDouble(day3TempStr);
		} catch (NumberFormatException e) {
			System.out.println("You entered an invalid number. Value defaulted to 0.");
			day3TempPrimitive = 0.0;
		}

		System.out.println("\n--- TEMPERATURE ANALYSIS ---");

		//	PART 2: Wrapper Object Creation
		Double day1TempWrapper = Double.valueOf(day1TempPrimitive);
		Double day2TempWrapper = Double.valueOf(day2TempPrimitive);

		//	PART 3: Comparison (compareTo)
		int comparison1_2Result = day1TempWrapper.compareTo(day2TempWrapper);
		if (comparison1_2Result < 0) System.out.printf("\nDay 1 (%.2fºC) was cooler than Day 2 (%.2fºC)\n", day1TempWrapper, day2TempWrapper);
		else if (comparison1_2Result > 0) System.out.printf("\nDay 1 (%.2fºC) was cooler warmer Day 2 (%.2fºC)\n", day1TempWrapper, day2TempWrapper);
		else System.out.printf("\nDay 1 (%.2fºC) was as warm as Day 2 (%.2fºC)\n", day1TempWrapper, day2TempWrapper);

		//	PART 4: Primitive Extraction (xxxValue)
		float day1TempFloat = day1TempWrapper.floatValue();
		int day2TempInt = day2TempWrapper.intValue();
		System.out.printf("\nExtracted Day 1 Temp (primitive float from Double wrapper): %.2fºC\n", day1TempFloat);
		System.out.printf("Extracted Day 2 Temp (primitive int from Double wrapper, truncated): %dºC\n", day2TempInt);

		//	Extension (For the Third Temperature & Finding Max)
		Double day3TempWrapper = day3TempPrimitive;

		List<Double> inputs = new ArrayList<>();
		inputs.add(day1TempWrapper); inputs.add(day2TempWrapper); inputs.add(day3TempWrapper);

		Double max = null;
		for (Double d: inputs) if (max == null || max.compareTo(d) < 0) max = d;

		System.out.printf("\nThe highest temperature recorded was: %.2fºC\n", max);

		System.out.println("--- PROGRAM END ---");

	}
}