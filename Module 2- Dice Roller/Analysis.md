
# Analysis

## Project Overview

The Dice Roller project is an Android application developed using Kotlin and Jetpack Compose. The application simulates rolling a six-sided dice.

When the user presses the **Roll** button, the application generates a random number between 1 and 6 and updates the dice image shown on the screen.

The main purpose of this project is to practice state management, user interaction, random number generation, conditional logic, images, and buttons in Jetpack Compose.

## Application Function

The application displays:

* A dice image
* A Roll button

Initially, the application displays dice value 1.

When the user presses the Roll button, the application generates a random number from 1 to 6. The corresponding dice image is then displayed.

For example:

```text
User presses Roll
        ↓
Random number generated
        ↓
Number between 1 and 6
        ↓
Matching dice image displayed
```

## Main Components

### MainActivity

`MainActivity` extends `ComponentActivity`.

Inside the `onCreate()` lifecycle method, `setContent()` is used to display the Compose interface.

The application uses `DiceRollerTheme` to apply the project's theme.

The main content is provided by `DiceRollerApp()`.

### DiceRollerApp

`DiceRollerApp()` is a composable function that prepares the main screen.

It uses:

`Modifier.fillMaxSize()`

and:

`wrapContentSize(Alignment.Center)`

to place the dice interface in the center of the screen.

The function calls `DiceWithButtonAndImage()` to display the dice and button.

### DiceWithButtonAndImage

This is the main composable responsible for the application interaction.

It contains:

* A state variable for the dice result
* Logic for selecting the dice image
* An Image composable
* A Button composable

## State Management

The dice value is stored using:

`remember { mutableStateOf(1) }`

This creates a Compose state variable called `result`.

The initial value is:

`1`

When the button is clicked, the state changes to a new random value.

Because `result` is Compose state, changing its value causes the UI to automatically recompose and display the corresponding dice image.

## Random Number Generation

The application generates the dice value using:

`(1..6).random()`

This creates a random integer between 1 and 6.

This is an important part of simulating the behavior of a physical six-sided dice.

## Image Selection

The application uses a `when` expression to select the correct image resource based on the dice result.

The mapping is:

```text
1 → dice_1
2 → dice_2
3 → dice_3
4 → dice_4
5 → dice_5
6 → dice_6
```

The selected resource is stored in `imageResource`.

The `Image` composable then displays the selected drawable.

## User Interaction

A Material 3 `Button` is used to allow the user to roll the dice.

The button uses an `onClick` event:

`result = (1..6).random()`

Every time the user clicks the button, a new random value is generated.

The `Text` composable displays the word:

`Roll`

The text uses a font size of `24.sp`.

## Android and Compose Concepts Applied

### 1. Jetpack Compose

The user interface is built using Jetpack Compose.

The project uses:

* `Surface`
* `Column`
* `Image`
* `Button`
* `Text`

### 2. remember and mutableStateOf

`remember` and `mutableStateOf` are used to store the current dice value.

This allows the UI to respond automatically when the dice result changes.

### 3. Button

The `Button` composable provides user interaction.

When the button is clicked, the dice result is updated.

### 4. Image

The `Image` composable displays the dice image corresponding to the current result.

The image is loaded using `painterResource()`.

### 5. when Expression

A Kotlin `when` expression is used to select the correct drawable resource for each dice value.

This demonstrates conditional logic in Kotlin.

### 6. Modifier

The project uses modifiers such as:

* `fillMaxSize()`
* `wrapContentSize()`

These are used to control the size and position of the interface.

### 7. Column

`Column` is used to arrange the dice image and Roll button vertically.

### 8. Alignment

`Alignment.Center` is used to position the main dice interface in the center of the screen.

### 9. String Resources

The button text is retrieved using:

`stringResource(R.string.roll)`

This keeps user-visible text inside Android string resources.

### 10. Preview

The application includes:

`@Preview(showBackground = true)`

This allows the interface to be previewed in Android Studio without running the application on a device.

## Technologies Used

* Kotlin
* Android Studio
* Jetpack Compose
* Material 3
* Android SDK

## Learning Outcome

Through this project, I learned how to create an interactive Android application using Jetpack Compose.

I learned how to:

* Store UI state using `remember`
* Use `mutableStateOf`
* Respond to button clicks
* Generate random numbers
* Use Kotlin `when` expressions
* Display images dynamically
* Organize UI elements using `Column`
* Use Compose modifiers
* Center content on the screen
* Use string resources
* Preview Compose interfaces

## Challenges

One important challenge was understanding how state changes affect the user interface.

The dice image does not need to be manually refreshed. When the value of `result` changes, Compose automatically recomposes the affected UI and displays the new image.

Another important concept was connecting the random number to the correct drawable resource using the `when` expression.

## Possible Improvements

The application could be improved by:

* Adding a dice rolling animation
* Adding sound effects
* Adding multiple dice
* Displaying the numerical dice result
* Keeping track of the number of rolls
* Adding a reset button
* Creating a history of previous dice results

## Conclusion

The Dice Roller project provided practical experience with interactive Android development using Jetpack Compose.

The project demonstrated how state, user interaction, random number generation, conditional logic, images, and buttons can work together to create a dynamic application.

This project strengthened my understanding of Compose state management and showed how changes in state can automatically update the user interface.
