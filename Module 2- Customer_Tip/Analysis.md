# Analysis

## Project Overview

The Customer Tip project is an Android tip calculator application developed using Kotlin and Jetpack Compose. The application allows the user to enter a bill amount and automatically calculates the tip using a default tip percentage of 15%.

The project focuses on user input, state management, calculation logic, number formatting, and Compose UI design.

## Application Function

The application provides a simple interface where the user enters the bill amount into a text field.

After the user enters the amount, the application:

1. Converts the entered text into a numeric value.
2. Calculates the tip using a 15% tip rate.
3. Formats the calculated value according to the device's local currency.
4. Displays the final tip amount on the screen.

For example, if the bill amount is RM100, the application calculates a 15% tip and displays the formatted result using the system's currency format.

## Main Components

### MainActivity

`MainActivity` extends `ComponentActivity` and uses `onCreate()` to initialize the application.

`enableEdgeToEdge()` is used to allow the application interface to use the available screen area while the Compose layout applies appropriate padding for system bars.

The user interface is loaded using `setContent()` and wrapped in the custom `TipTimeTheme`.

### TipTimeLayout

`TipTimeLayout()` is the main composable function responsible for displaying the calculator interface.

It contains:

* A title using `Text`
* A bill amount input using `TextField`
* The calculated tip amount using `Text`
* A `Spacer` for additional vertical spacing

The layout uses a `Column` to arrange these elements vertically.

### EditNumberField

`EditNumberField()` is a reusable composable function for collecting the bill amount from the user.

It uses a `TextField` with:

* A single-line input
* A bill amount label
* Numeric keyboard input
* A callback to update the entered value

### calculateTip

The `calculateTip()` function performs the tip calculation.

The default tip percentage is:

```text
15%
```

The calculation is:

```text
tip = tipPercent / 100 × amount
```

The result is then formatted using:

```kotlin
NumberFormat.getCurrencyInstance()
```

This allows the displayed currency format to follow the device's local settings.

## Technologies Used

* Kotlin
* Android Studio
* Jetpack Compose
* Material 3
* Android SDK
* Java `NumberFormat`

## Compose Concepts Applied

### 1. State Management

The application uses:

```kotlin
var amountInput by remember { mutableStateOf("") }
```

This stores the current value entered by the user.

When the user types into the `TextField`, the state is updated and Compose automatically recomposes the affected UI.

### 2. remember and mutableStateOf

`remember` keeps the value during recomposition, while `mutableStateOf` creates observable state.

This allows the application to respond immediately when the bill amount changes.

### 3. TextField

The `TextField` component is used to collect input from the user.

The application also uses:

```kotlin
KeyboardOptions(keyboardType = KeyboardType.Number)
```

so that a numeric keyboard can be displayed for the bill amount.

### 4. Composable Functions

The interface is divided into reusable composable functions such as `TipTimeLayout()` and `EditNumberField()`.

This makes the code easier to organize and maintain.

### 5. Modifier

Several modifiers are used to control the layout, including:

* `fillMaxSize()`
* `fillMaxWidth()`
* `padding()`
* `height()`
* `verticalScroll()`
* `statusBarsPadding()`
* `safeDrawingPadding()`

These modifiers control size, spacing, scrolling, and safe screen areas.

### 6. MaterialTheme

`MaterialTheme.typography.displaySmall` is used to make the calculated tip amount more prominent.

The application also uses a custom `TipTimeTheme` to apply the application's Material Design theme.

### 7. String Resources

The application uses:

```kotlin
stringResource()
```

to obtain text from the application's string resources rather than hard-coding all displayed text directly in the composable functions.

### 8. Preview

The `@Preview` annotation is used in `TipTimeLayoutPreview()` so that the user interface can be previewed directly in Android Studio.

## Data Processing

The bill amount is initially stored as a `String` because it comes from a text field.

The application converts it using:

```kotlin
amountInput.toDoubleOrNull() ?: 0.0
```

This prevents the application from crashing when the input is empty or cannot be converted into a valid number.

The converted value is then passed to `calculateTip()`.

## Learning Outcome

This project helped me understand how to build an interactive Android application using Jetpack Compose.

I learned how to:

* Receive user input using `TextField`
* Store and update UI state
* Use `remember` and `mutableStateOf`
* Convert text input into numeric data
* Perform calculations using Kotlin
* Format currency values
* Create reusable composable functions
* Use Material 3 components
* Organize layouts using `Column` and `Modifier`
* Preview Compose interfaces in Android Studio

## Challenges

One important challenge was understanding how user input is handled in a declarative UI framework.

Instead of manually changing the displayed result, the application stores the input as state. When the state changes, Compose automatically recomposes the UI and displays the updated tip amount.

Another important concept was safely converting the text entered by the user into a `Double`. Using `toDoubleOrNull()` prevents invalid input from causing a runtime error.

## Possible Improvements

The application could be improved by allowing the user to choose their own tip percentage instead of always using the default 15%.

Other possible improvements include:

* Adding a tip percentage input field
* Calculating the total bill including the tip
* Adding a bill-splitting feature
* Adding input validation
* Improving the visual design
* Providing clearer feedback for empty input

## Conclusion

The Customer Tip project strengthened my understanding of interactive user interfaces and state management in Jetpack Compose. It demonstrated how user input can be connected directly to application logic and how changes in state can automatically update the interface.

This project also provided practical experience with Kotlin calculations, currency formatting, Material 3, reusable composables, and responsive Compose layouts.

