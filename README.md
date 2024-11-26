# Java Strategy Game

A turn-based strategy game where players expand their territory, manage resources, and build their empire. Develop your land by constructing farms and villages while adapting your strategy to different terrain types.

## Game Overview

Players start with a single tile and expand their territory by constructing buildings. Currently, players can build farms to produce wheat and establish villages. The game features an interactive 30x20 tile map with various terrain types that affect building placement.

## Current Features

### Map and Terrain
- 30x20 interactive grid
- Four terrain types:
  - Plains: Basic buildable terrain
  - Hills: Elevated terrain
  - Water: Unbuildable terrain
  - Forest: Wooded areas

### Buildings and Resources
- Farms: Generate wheat each turn
- Villages: Base settlement buildings
- Resource system tracking wheat production

### Interface
- Visual tile-based map
- Interactive hover effects
- Terrain coloring system
- Building placement system

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 17 or higher
- JavaFX SDK 23.0.1
- Git for cloning the repository

### Installation
1. Clone the repository:
   ```bash
   git clone [your-repository-url]
   ```
2. Ensure JavaFX is properly configured in your development environment
3. Run `Main.java` to start the game

### Basic Gameplay
1. Each game starts with a single controlled tile
2. Click on tiles to view information
3. Build farms to generate wheat each turn
4. Buildings can only be placed on valid terrain (not water)
5. Each tile can hold one building maximum

## Technical Structure

### Core Components
```
src/
├── Building.java       # Building type enumeration
├── GameEngine.java     # Core game logic
├── Main.java          # JavaFX application and UI
├── RunGame.java       # Game launcher
├── Terrain.java       # Terrain type enumeration
└── Tile.java          # Tile class definition
```

### Key Classes
- **GameEngine**: Manages game state, resource production, and building placement
- **Tile**: Handles individual map tile properties and states
- **Main**: Controls the JavaFX interface and user interactions

## Planned Features

### Resources
- Multiple resource types beyond wheat
- Resource gathering and management
- Resource trading mechanics

### Buildings
- Additional building types with unique functions
- Building upgrade systems
- Different building effects based on terrain

### Combat
- Unit creation and management
- Battle mechanics
- Territory conquest

### Computer Opponents
- AI-controlled adversaries
- Strategic decision-making

## Development

This project is under active development. Feel free to check the repository for updates and new features.
