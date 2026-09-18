# Analysis

## Project Overview

MyArtSpace is an Android application developed using Kotlin and Jetpack Compose. The application displays a collection of artwork and allows the user to move between different artworks using Previous and Next buttons.

The project focuses on data classes, lists, state management, image display, button interactions, layout organization, and Material 3 components.

## Application Function

The application displays one artwork at a time.

Each artwork contains:

* An image
* A title
* An artist name
* A year

The application contains four artworks:

1. Espresso Art
2. Latte Art Photo
3. Cappuccino Art Photo
4. Mocha Art Photo

The user can navigate through the artworks using the Previous and Next buttons.

The application also displays the current position, such as:

`1 of 4`

This allows the user to know which artwork is currently being viewed.

## Data Model

The project defines an `Artwork` data class:

`data class Artwork`

The class contains four properties:

* `imageResId`
* `title`
* `artist`
* `year`

This provides a structured way to store information about each artwork.

The application then creates a list called `artworks` containing four `Artwork` objects.

Using a data class and list makes the application easier to manage because the same structure can be reused for multiple artworks.

## Main Components

### MainActivity

`MainActivity` extends `ComponentActivity`.

Inside the `onCreate()` lifecycle method, `setContent()` loads the Compose interface.

The application uses `MyArtSpaceTheme` and calls `MyArtSpaceApp()` to display the main application.

### MyArtSpaceApp

`MyArtSpaceApp()` controls which artwork is currently displayed.

It uses:

`remember { mutableStateOf(0) }`

to store the current artwork index.

The current artwork is obtained using:

`val currentArtwork = artworks[currentIndex]`

The composable then passes the current artwork and navigation functions to `ArtSpaceScreen()`.

## State Management

The application uses Compose state to control navigation.

The variable:

`currentIndex`

stores the position of the currently displayed artwork.

Initially, the value is:

`0`

When the user presses Next, the index is increased.

When the user presses Previous, the index is decreased.

Because `currentIndex` is a Compose state variable, changing it automatically causes the UI to recompose and display the new artwork.

## Navigation Logic

The Next button uses:

`(currentIndex + 1) % artworks.size`

This allows the application to move to the next artwork.

When the user reaches the last artwork, pressing Next returns to the first artwork.

The Previous button uses:

`(currentIndex - 1 + artworks.size) % artworks.size`

This allows the user to move backwards.

When the user is viewing the first artwork and presses Previous, the application moves to the last artwork.

This creates continuous circular navigation.

## ArtSpaceScreen

`ArtSpaceScreen()` is responsible for displaying the selected artwork.

It receives:

* `artwork`
* `currentIndex`
* `totalArtworks`
* `onPrevious`
* `onNext`

This separation keeps the screen responsible for displaying the UI while `MyArtSpaceApp()` manages the current state.

## Image Display

The artwork image is displayed using the `Image` composable.

The image resource is loaded using:

`painterResource(id = artwork.imageResId)`

The image uses:

`ContentScale.Fit`

so that the artwork fits within the available area while maintaining its original proportions.

The image is given a height of `400.dp` and fills the available width.

The artwork title is also used as the image content description, providing useful accessibility information.

## Layout Design

The application uses a `Scaffold` as the main screen structure.

Inside the `Scaffold`, a `Column` organizes the content vertically.

The layout contains:

1. Artwork image
2. Artwork title
3. Artist and year
4. Current artwork position
5. Previous and Next buttons

The `Column` uses:

`Arrangement.SpaceEvenly`

to distribute the available vertical space between these elements.

## Text Information

The artwork title uses:

`MaterialTheme.typography.headlineSmall`

and:

`FontWeight.Bold`

to make the title more noticeable.

The artist and year use:

`MaterialTheme.typography.bodyLarge`

The current artwork position uses:

`MaterialTheme.typography.bodyMedium`

This creates different levels of text emphasis throughout the application.

## User Interaction

The application provides two Material 3 `Button` components:

* Previous
* Next

The buttons receive callback functions from `MyArtSpaceApp()`.

When the buttons are clicked, the corresponding callback updates `currentIndex`, which causes the displayed artwork to change.

## Android and Compose Concepts Applied

### 1. Data Class

The `Artwork` data class is used to represent an artwork as a single structured object.

### 2. List

The application stores multiple artwork objects in the `artworks` list.

This makes it possible to navigate through a collection of artworks.

### 3. State Management

`remember` and `mutableStateOf` are used to store the current artwork index.

### 4. Scaffold

`Scaffold` provides the main structure of the application screen.

### 5. Column

`Column` is used to arrange the main content vertically.

### 6. Row

`Row` is used for the Previous and Next buttons so that they appear next to each other horizontally.

### 7. Image

`Image` displays the selected artwork image using a drawable resource.

### 8. ContentScale

`ContentScale.Fit` ensures that the artwork maintains its aspect ratio while fitting within the available area.

### 9. Button

Material 3 buttons provide the interaction required to navigate between artworks.

### 10. Modifier

The project uses modifiers such as:

* `fillMaxSize()`
* `fillMaxWidth()`
* `height()`
* `padding()`

These control the size and spacing of the interface.

### 11. MaterialTheme

The application uses `MaterialTheme.typography` for consistent typography.

### 12. Preview

`ArtSpacePreview()` uses the `@Preview` annotation to allow the interface to be previewed inside Android Studio.

## Technologies Used

* Kotlin
* Android Studio
* Jetpack Compose
* Material 3
* Android SDK

## Learning Outcome

Through this project, I learned how to build a multi-item interactive application using Jetpack Compose.

I learned how to:

* Create and use data classes
* Store objects in a list
* Manage UI state
* Update the UI when state changes
* Display images from drawable resources
* Use buttons and click callbacks
* Build reusable composable functions
* Use `Scaffold`
* Arrange content with `Column` and `Row`
* Use Material typography
* Control image scaling
* Create circular navigation logic
* Add content descriptions for images
* Preview Compose UI using `@Preview`

## Challenges

One of the main challenges was implementing the Previous and Next navigation correctly.

The application needs to continue from the last artwork back to the first artwork and from the first artwork back to the last artwork.

The modulo operation was used to achieve this circular navigation.

Another challenge was separating application state from the screen UI. `MyArtSpaceApp()` manages the current artwork, while `ArtSpaceScreen()` receives the required data and callback functions.

## Possible Improvements

The application could be improved by:

* Adding more artwork items
* Adding swipe gestures for navigation
* Adding an artwork category or description
* Adding animations when changing artworks
* Adding a progress indicator
* Improving the visual design
* Adding accessibility improvements
* Allowing users to select an artwork directly

## Conclusion

The MyArtSpace project provided practical experience with state management, structured data, collections, navigation logic, image handling, and interactive UI development in Jetpack Compose.

The use of the `Artwork` data class and artwork list makes the application organized and reusable, while the state-based navigation allows the user to move smoothly through the collection.

This project strengthened my understanding of how data, application state, and Compose UI can work together to create an interactive Android application.
