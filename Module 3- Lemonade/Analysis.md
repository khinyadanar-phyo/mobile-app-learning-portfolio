# Analysis

## Project Overview

The Lemonade project is an interactive Android application developed using Kotlin and Jetpack Compose. The application simulates the process of making and drinking lemonade through a four-step interaction.

The user progresses through the application by tapping the image at each stage. The project focuses on state management, conditional UI, button interaction, random number generation, reusable composable functions, and Material 3 components.

## Application Function

The application contains four main steps:

1. Pick a lemon from the tree.
2. Squeeze the lemon several times.
3. Drink the lemonade.
4. Restart the process with an empty glass.

The application changes the displayed image and instruction text according to the current step.

The overall process is:

Pick Lemon → Squeeze Lemon → Drink Lemonade → Empty Glass → Start Again

## Main Components

### MainActivity

`MainActivity` extends `ComponentActivity`.

Inside the `onCreate()` lifecycle method, `enableEdgeToEdge()` is called and `setContent()` is used to display the Compose interface.

The main content of the application is `LemonadeApp()`.

### LemonadeApp

`LemonadeApp()` is the main composable function that controls the application state and screen flow.

It contains two state variables:

* `currentStep`
* `squeezeCount`

The UI is then selected using a Kotlin `when` expression based on `currentStep`.

## State Management

The project uses Compose state with:

`remember { mutableStateOf(...) }`

The first state variable is:

`currentStep`

It starts at:

`1`

This determines which stage of the lemonade process is currently displayed.

The second state variable is:

`squeezeCount`

It starts at:

`0`

This tracks how many times the user still needs to tap the lemon during the squeezing stage.

Because these are Compose state variables, changes automatically cause the affected UI to recompose.

## Four-Step Application Flow

### Step 1: Pick a Lemon

The first step displays a lemon tree image.

The instruction says:

"Tap the lemon tree to pick a lemon"

When the image is clicked:

* `currentStep` changes from 1 to 2.
* `squeezeCount` is randomly assigned a value between 2 and 4.

The random value means the user must squeeze the lemon a different number of times each time a new lemon is picked.

### Step 2: Squeeze the Lemon

The second step displays the lemon squeezing image.

The instruction says:

"Keep tapping the lemon to squeeze it"

Each time the image is clicked:

`squeezeCount--`

decreases the remaining squeeze count by one.

When the value reaches zero:

`currentStep = 3`

The application then moves to the drinking stage.

### Step 3: Drink the Lemonade

The third step displays a glass of lemonade.

The instruction says:

"Tap the glass to drink the lemonade"

When the image is clicked, `currentStep` changes to 4.

### Step 4: Empty Glass

The fourth step displays an empty glass.

The instruction says:

"The glass is empty. Tap to start again"

When the image is clicked:

`currentStep = 1`

The application returns to the first step and starts the process again.

## LemonTextAndImage

`LemonTextAndImage()` is a reusable composable function used by all four steps.

It receives:

* `text`
* `imageResourceId`
* `contentDescription`
* `onImageClick`
* `modifier`

This allows the same UI structure to be reused while changing the image, description, instruction, and click behavior for each stage.

This is an example of creating reusable UI components instead of repeating the same layout code multiple times.

## Layout Design

The application uses a `Scaffold` as the overall screen structure.

The `Scaffold` contains a top app bar and the main application content.

Inside the content area, a `Surface` fills the available screen.

`LemonTextAndImage()` uses a `Box` containing a `Column`.

The `Column` uses:

`horizontalAlignment = Alignment.CenterHorizontally`

and:

`verticalArrangement = Arrangement.Center`

to center the image button and instruction text on the screen.

The basic layout is:

Top App Bar

↓

Clickable Lemon Image

↓

Instruction Text

## Top App Bar

The application uses `CenterAlignedTopAppBar`.

The title is:

"Lemonade"

The title uses a font size of `24.sp`.

The top app bar uses:

`MaterialTheme.colorScheme.primaryContainer`

as its container color.

This provides a clear application title at the top of the screen.

## Interactive Image

The image is placed inside a Material 3 `Button`.

This means the user can tap the image to perform the action required for each stage.

The button uses:

`RoundedCornerShape(16.dp)`

to create rounded corners.

The button color uses:

`MaterialTheme.colorScheme.tertiaryContainer`

The image is displayed using the `Image` composable and is given a size of `150.dp` by `150.dp`.

## Random Squeeze Count

One of the main interactive features is the randomized squeeze requirement.

When the user picks a lemon, the application executes:

`(2..4).random()`

This generates a random number from 2 to 4.

The generated number determines how many times the user needs to tap the lemon before moving to the next stage.

This makes the squeezing interaction slightly different each time.

## Android and Compose Concepts Applied

### 1. State Management

`remember` and `mutableStateOf` are used to store the current application state.

### 2. Conditional UI

A Kotlin `when` expression is used to determine which content should be displayed based on `currentStep`.

### 3. Button

A Material 3 `Button` is used to make the image interactive.

### 4. Image

The `Image` composable displays a different drawable resource at each stage.

### 5. Scaffold

`Scaffold` provides the overall application structure and contains the top app bar and main content.

### 6. CenterAlignedTopAppBar

`CenterAlignedTopAppBar` provides the application title at the top of the screen.

### 7. MaterialTheme

The project uses Material 3 theme colors such as `primaryContainer`, `tertiaryContainer`, and `background`.

### 8. Reusable Composable

`LemonTextAndImage()` is reused for all four application steps.

This reduces code duplication and makes the application easier to maintain.

### 9. Modifier

The project uses modifiers such as:

* `fillMaxSize()`
* `padding()`
* `width()`
* `height()`

These control the size, position, and spacing of UI components.

### 10. RoundedCornerShape

`RoundedCornerShape(16.dp)` is used to give the interactive button rounded corners.

### 11. Spacer

`Spacer` is used to create vertical space between the image button and instruction text.

### 12. Preview

The project includes `LemonPreview()` with the `@Preview` annotation so that the interface can be previewed directly in Android Studio.

## Accessibility

Each image is given a `contentDescription`, such as:

* "Lemon tree"
* "Lemon"
* "Glass of lemonade"
* "Empty glass"

This provides descriptive information about the images for accessibility tools.

## Technologies Used

* Kotlin
* Android Studio
* Jetpack Compose
* Material 3
* Android SDK

## Learning Outcome

Through this project, I learned how to build a state-driven interactive application using Jetpack Compose.

I learned how to:

* Manage application state
* Use `remember` and `mutableStateOf`
* Change UI based on state
* Use `when` expressions
* Handle button click events
* Generate random values
* Build reusable composable functions
* Display images from drawable resources
* Use Material 3 components
* Create a top app bar
* Organize a screen using `Scaffold`, `Box`, and `Column`
* Add accessibility descriptions
* Preview Compose UI in Android Studio

## Challenges

One of the main challenges was managing the four different stages of the lemonade process.

The application needs to display a different image and instruction at each stage. Using `currentStep` as state and a `when` expression provided a simple way to control this process.

Another challenge was implementing the squeezing stage. The user cannot move to the next step immediately; the application first generates a random squeeze count and decreases it every time the lemon is tapped.

Creating `LemonTextAndImage()` as a reusable composable was also important because the same layout is used for all four stages.

## Possible Improvements

The application could be improved by:

* Adding animation when squeezing the lemon
* Adding sound effects
* Showing the remaining number of squeezes
* Adding a progress indicator
* Improving the visual design of the lemonade process
* Adding more detailed accessibility support
* Adding a reset button
* Adding animations when moving between stages

## Conclusion

The Lemonade project provided practical experience with interactive and state-based Android application development.

The project demonstrates how Compose state can control an application's flow, how reusable composable functions can reduce repeated code, and how user interactions can update the interface automatically.

The combination of state management, random number generation, conditional UI, buttons, images, and Material 3 components helped strengthen my understanding of modern Android development with Jetpack Compose.
