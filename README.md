# Feudal Strategy

A medieval strategy game about building and expanding your territory. Construct cities, farms, and other buildings while managing resources to grow your realm.

## Setup

### Requirements
- Java JDK 17+
- JavaFX SDK 23.0.1 ([Download](https://openjfx.io/))

### Quick Start
1. Clone the repository
2. Download JavaFX SDK 23.0.1
3. Remove `.example` from the following files and update the JavaFX paths:
   - `.vscode/settings.json.example`
   - `.vscode/launch.json.example`
   - `run.bat.example`
4. Update the paths in these files to point to your JavaFX SDK lib folder
5. Run:
   - Windows: Double-click `run.bat`
   - VSCode: F5 or Run > Start Debugging

Note: Replace `<path-to-javafx>` in the configuration files with your JavaFX SDK lib folder path (e.g., `C:/Program Files/Java/javafx-sdk-23.0.1/lib`).

### VSCode Setup
1. Install Extension Pack for Java
2. Project should be ready to run (configurations included)

## Project Structure
```
feudal-strategy/
├── lib/            # JavaFX JAR files
├── src/           # Source code
├── .vscode/       # VSCode configuration
└── run.bat        # Run script
```

## Planned Features
- City building and expansion
- Resource management
- Building system (farms, mines, etc.)
- Territory expansion mechanics

## Contributing
Project is in early development. Issues and contributions welcome!