# Analysis

## Project Overview

The Scrollable project is an Android application developed using Kotlin and Jetpack Compose. The application displays a scrollable list of positive affirmation messages together with related images.

The project focuses on displaying lists efficiently using `LazyColumn`, creating reusable composable functions, working with data models, loading resources, and organizing information into cards.

## Application Function

The application displays a collection of affirmation cards.

Each card contains:

* An image
* An affirmation message

The user can scroll vertically through the list to view all available affirmations.

The application obtains the affirmation data from a `Datasource` class using `Datasource().loadAffirmations()`.

The data is represented using the `Affirmation` model.

## Main Components

### MainActivity

`MainActivity` extends `ComponentActivity`.

Inside the `onCreate()` lifecycle method, `setContent()` is used to load the Compose interface.

The application uses `AffirmationsTheme` and a Material 3 `Surface` to provide the main screen.

The main application content is displayed through `AffirmationsApp()`.

### AffirmationsApp

`AffirmationsApp()` loads the list of affirmations from the `Datasource`.

It passes the resulting list to `AffirmationList()`.

This separates the data loading from the composable responsible for displaying the list.

### AffirmationList

`AffirmationList()` receives a list of `Affirmation` objects.

It uses `LazyColumn` to display the list vertically.

For every affirmation in the list, an `AffirmationCard()` is created.

The cards are given `8.dp` padding to provide spacing between items.

## LazyColumn

`LazyColumn` is used to create the scrollable list.

Unlike a normal `Column`, `LazyColumn` is designed for displaying a collection of items efficiently.

The list items are provided using `items(affirmationList)`.

For each item, the corresponding `AffirmationCard()` is displayed.

This is the main feature that makes the application scrollable.

## AffirmationCard

`AffirmationCard()` is a reusable composable function that displays one affirmation.

It receives an `Affirmation` object containing the resources needed for the image and text.

The card contains:

1. An image
2. An affirmation text

The layout inside the card uses a `Column`.

## Card Component

The Material 3 `Card` composable is used as a container for each affirmation.

Using cards gives each item a clear visual boundary and creates a structured list layout.

## Image Display

The application loads the image using `painterResource(affirmation.imageResourceId)`.

The image uses `Modifier.fillMaxWidth()` and `Modifier.height(194.dp)` so that each image fills the card width and has a fixed height.

The application also uses `ContentScale.Crop` to fill the available image area while cropping parts of the image when necessary.

The image content description is obtained from the affirmation string resource using `stringResource(affirmation.stringResourceId)`.

This provides descriptive information for accessibility.

## Affirmation Text

The text is obtained from the application's string resources.

The code uses `LocalContext.current.getString(affirmation.stringResourceId)` to retrieve the actual affirmation message.

The text uses `MaterialTheme.typography.headlineSmall` and `Modifier.padding(16.dp)` to make the message clear and provide spacing inside the card.

## Data Model

The application uses an `Affirmation` model.

Each `Affirmation` contains:

* `stringResourceId`
* `imageResourceId`

This connects the message with its corresponding image.

The application also uses a `Datasource` class to load the collection of affirmation objects.

This separates the application's data from its user interface.

## Android and Compose Concepts Applied

### 1. Jetpack Compose

The user interface is created using Jetpack Compose.

The project uses:

* `Surface`
* `LazyColumn`
* `Card`
* `Column`
* `Image`
* `Text`

### 2. LazyColumn

`LazyColumn` creates the vertically scrollable list of affirmation cards.

### 3. items

The `items()` function is used to iterate through the list of `Affirmation` objects and create a UI item for each one.

### 4. Card

`Card` provides a Material Design container for each affirmation.

### 5. Column

`Column` is used inside each card to arrange the image and text vertically.

### 6. Image

The `Image` composable displays the image associated with each affirmation.

### 7. ContentScale

`ContentScale.Crop` is used to make the image fill its designated area.

### 8. Resource Management

The application uses Android resource IDs for images and text.

`painterResource()` loads image resources, while `stringResource()` and `getString()` are used to retrieve text resources.

### 9. LocalContext

`LocalContext.current` provides access to the Android context so that the application can retrieve the affirmation text from its resource ID.

### 10. MaterialTheme

The project uses Material 3 typography and the application's custom `AffirmationsTheme`.

### 11. Modifier

Modifiers such as `fillMaxSize()`, `fillMaxWidth()`, `height()`, and `padding()` are used to control the size, spacing, and arrangement of components.

### 12. Preview

The project includes `AffirmationCardPreview()` using `@Preview`.

This allows an individual affirmation card to be previewed in Android Studio during development.

## Layout Design

The application follows a card-based scrollable list structure:

Affirmation List

↓

Affirmation Card

↓

Image

↓

Affirmation Text

Multiple cards are displayed vertically inside the `LazyColumn`.

## Accessibility

The image uses the affirmation text as its content description.

This provides meaningful information about the image to accessibility services.

## Technologies Used

* Kotlin
* Android Studio
* Jetpack Compose
* Material 3
* Android SDK
* AndroidX

## Learning Outcome

Through this project, I learned how to create a scrollable list-based Android application using Jetpack Compose.

I learned how to:

* Display lists using `LazyColumn`
* Use the `items()` function
* Create reusable composable functions
* Create card-based layouts
* Display images from resources
* Display text from string resources
* Use a data model to organize information
* Load data from a datasource
* Use `ContentScale`
* Apply Material 3 styling
* Use `Modifier` for layout control
* Add meaningful image content descriptions
* Create Compose previews

## Challenges

One of the main challenges was understanding how `LazyColumn` differs from a normal `Column`.

I learned that `LazyColumn` is designed for lists and provides an appropriate way to display multiple items in a vertically scrollable interface.

Another important concept was understanding how data is passed from the `Datasource` to the UI. The `Affirmation` model connects each image resource with its corresponding text resource.

Creating `AffirmationCard()` as a reusable composable also helped reduce repeated UI code.

## Possible Improvements

The application could be improved by:

* Adding more affirmation items
* Adding categories for different types of affirmations
* Adding favorite or bookmark functionality
* Adding animations when cards appear
* Improving the card styling
* Adding a search feature
* Allowing users to share an affirmation
* Adding more accessibility features

## Conclusion

The Scrollable project provided practical experience with list-based UI development in Jetpack Compose.

The project demonstrated how a data model, datasource, `LazyColumn`, reusable composables, cards, images, and resource strings can work together to create a structured and scrollable Android application.

This project strengthened my understanding of lazy lists, reusable UI components, resource management, and separating application data from the user interface.

