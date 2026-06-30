# Snack Display App

## Description
The **Snack Display App** is a simple Android application designed to manage a list of snacks. Users can view a list of snacks, add new ones with their price and description via a dialog, and clear the entire list using a menu option.

## Technical Details
The project is built using modern Android development practices:
- **Architecture**: MVVM (Model-View-ViewModel) to ensure separation of concerns and testability.
- **Database**: Room Persistence Library for local data storage.
- **UI Components**:
    - **RecyclerView**: For efficient display of the snack list.
    - **ListAdapter & DiffUtil**: For optimized list updates.
    - **ViewBinding**: Used to interact with UI elements without `findViewById`, as per requirements.
    - **Material Design**: Utilizes MaterialCardView and FloatingActionButton for a modern look.
- **Asynchronous Operations**: Kotlin Coroutines are used for database operations to keep the UI thread responsive.
- **Naming Convention**: All internal identifiers and IDs follow the `am` prefix convention.

## Project Structure
- `model/`: Contains the `Snack` data class (Room Entity).
- `data/`: Contains `SnackDao` and `SnackRoomDatabase`.
- `repository/`: Contains `SnackRepository` to abstract data access.
- `viewmodel/`: Contains `SnackViewModel` to provide data to the UI.
- `adapter/`: Contains `SnackAdapter` for the RecyclerView.
- `MainActivity`: The single screen of the app, handling the list display and user interactions.

## Content
- **Menu**: Includes an option to "Delete All" snacks.
- **List**: Displays snack name, price, and description.
- **Add Snack**: A floating button opens a dialog to input snack details.
