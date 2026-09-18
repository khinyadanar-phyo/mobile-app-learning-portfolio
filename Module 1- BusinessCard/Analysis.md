
# Analysis

## Project Overview

Module 1 is a Business Card Android application developed using Kotlin and Jetpack Compose. The purpose of the project is to practice creating a structured user interface with images, text, icons, dividers, rows, and columns.

The application presents a personal business card containing a profile image, name, job title, and contact information.

## Application Function

The application displays a business card interface with the following main sections:

* A profile image
* A name
* A professional title
* Contact information
* Phone and email icons
* Horizontal dividers between contact sections

The screen is organized vertically so that the information appears in a clear business-card style layout.

## Main Components

### MainActivity

MainActivity extends ComponentActivity.

Inside the onCreate() lifecycle method, enableEdgeToEdge() is called and setContent() is used to load the Jetpack Compose interface.

The main composable displayed by the activity is BusinessCard().

### BusinessCard

BusinessCard() is the main composable function of the application.

It uses a Column with horizontalAlignment = Alignment.CenterHorizontally to arrange the business card content vertically and keep the main content centered horizontally.

The composable contains an image, name text, professional title text, a Spacer, horizontal dividers, and contact information rows.

### Profile Image

The application loads an image from the drawable resources using painterResource(). The image is displayed using the Image composable.

The image uses Modifier.fillMaxWidth() so that it occupies the available width.

### Text Components

Two Text composables are used to display the person's name and professional title.

Different font sizes and colors are applied to make the name and job title visually distinct.

### ContactInfoRow

ContactInfoRow() is a reusable composable created for displaying contact information.

It receives a text value and an ImageVector as parameters. This allows the same composable to be reused for different types of contact information.

The function uses a Row to place the icon and text horizontally.

## Android and Compose Concepts Applied

### 1. Jetpack Compose

The entire user interface is created using Jetpack Compose rather than XML layouts.

The project uses several Compose components including Column, Row, Image, Text, Icon, Spacer, HorizontalDivider, and Surface.

### 2. Column

Column is used to arrange the major business card elements vertically.

This creates the overall structure of the business card.

### 3. Row

Row is used inside ContactInfoRow() to place the contact icon and contact text next to each other horizontally.

### 4. Image

The Image composable displays the application image using a drawable resource.

### 5. Icons

The application uses Material icons for phone and email:

Icons.Rounded.Phone

Icons.Rounded.Email

These icons make the contact information easier to recognize visually.

### 6. HorizontalDivider

HorizontalDivider is used to separate the different contact information sections and improve the visual organization of the card.

### 7. Modifier

The project uses several modifiers, including fillMaxWidth(), padding(), and weight().

These modifiers control the size, spacing, and distribution of UI elements.

### 8. Weight

Inside ContactInfoRow(), weight is used to control the amount of horizontal space given to the icon and text.

The icon uses weight 1f, while the text uses weight 3f.

This creates a larger area for the contact text than for the icon.

### 9. ImageVector

The icon parameter uses the ImageVector type.

This allows ContactInfoRow() to accept different Material icons while keeping the composable reusable.

### 10. Preview

The application includes a Preview composable using @Preview(showBackground = true).

The DefaultPreview() composable allows the business card interface to be viewed directly inside Android Studio during development.

## Layout Design

The layout follows a simple vertical structure:

Profile Image

↓

Name

↓

Professional Title

↓

Spacing

↓

Divider

↓

Phone Contact Row

↓

Divider

↓

Email Contact Row

↓

Divider

This structure keeps the information organized and easy to read.

## Testing

The project also contains an instrumented test called ExampleInstrumentedTest.

The test uses AndroidJUnit4 and obtains the application's target context using InstrumentationRegistry.

The test then verifies that the application's package name matches the expected package name.

This provides a basic check that the test is running against the correct application.

## Technologies Used

* Kotlin
* Android Studio
* Jetpack Compose
* Material Design and Material Icons
* AndroidX
* JUnit
* AndroidJUnit4

## Learning Outcome

Through this project, I learned how to create a complete Android user interface using Jetpack Compose.

I learned how to:

* Create an Android activity using ComponentActivity
* Use setContent() to display Compose UI
* Arrange components with Column and Row
* Display images with Image
* Display text with Text
* Use Material icons
* Separate content with dividers
* Control layout using Modifier
* Use weight() for proportional spacing
* Create reusable composable functions
* Preview a Compose interface using @Preview
* Perform a basic instrumented Android test

## Challenges

One of the main challenges was understanding how different Compose layout components work together.

I needed to understand when to use Column for vertical arrangement and Row for horizontal arrangement. I also learned how weight() can be used to distribute available space between UI elements.

Another important concept was creating ContactInfoRow() as a reusable function instead of repeating the same layout code for each contact method.

## Possible Improvements

The application could be improved by:

* Using a more responsive image size instead of always filling the width
* Improving the color scheme and typography
* Adding more contact methods
* Making the contact information interactive
* Adding accessibility-friendly content descriptions
* Improving spacing for different screen sizes
* Applying a more consistent Material theme

## Conclusion

The Business Card project introduced me to the fundamental concepts of Jetpack Compose and Android UI development.

By creating this application, I gained practical experience with layouts, images, text, icons, reusable composables, modifiers, previews, and basic Android testing.

This project provided a foundation for developing more interactive and complex Android applications in later modules.
