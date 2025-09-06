# CivilStateRP - Half-Life 2 Roleplay Mod

## Overview

CivilStateRP is a comprehensive Half-Life 2 roleplay modification for Minecraft 1.16.5 using Forge. This mod recreates the atmosphere and gameplay mechanics of Half-Life 2's Civil Protection era, providing players with a rich roleplay experience featuring professions, loyalty systems, advanced GUI interfaces, and comprehensive player interaction mechanics.

## Features

### Core Systems
- **Advanced HUD System**: Real-time display of player information including tokens, loyalty, profession, and status
- **C-Menu Interface**: Radial menu system for quick access to identity, inventory, radio, requests, actions, and settings
- **Player Data Management**: Persistent SQLite database storing player tokens, loyalty, professions, violations, and transaction history
- **Network Synchronization**: Robust client-server communication for real-time data updates

### Items & Equipment
- **CID Cards**: Civil identification cards with player information
- **Suitcases**: Portable storage with lock functionality and placement system
- **Radio Equipment**: Multi-channel communication system with encryption support
- **Security Equipment**: Tasers, batons, zip ties for law enforcement
- **Scanner Devices**: Area scanning and monitoring equipment
- **Contraband System**: Illegal items with detection mechanics

### Professions & Progression
- **Citizen**: Basic civilian status
- **Loyalist**: Enhanced citizen with privileges
- **Trusted Loyalist**: Higher security clearance
- **Civil Protection**: Law enforcement officers with ranks
- **OTA (Overwatch Transhuman Arm)**: Elite security forces
- **Government Officials**: Administrative personnel with special permissions
- **Resistance**: Underground faction (optional)

### Roleplay Mechanics
- **Loyalty System**: 0-100% loyalty affecting access and privileges
- **Search & Detain**: Law enforcement can search and detain players
- **Violation Logging**: Comprehensive logging of all infractions and actions
- **Token Economy**: In-game currency system with transaction tracking
- **Radio Communication**: Multi-channel radio system with logging
- **Evidence System**: Photo evidence and evidence bags

### Commands (Russian/English)
- `/чемодан` / `/suitcase` - Place suitcase block
- `/форма` / `/profession` - Access profession system
- `/го` / `/government` - Spawn government official NPCs
- `/ота` / `/ota` - Spawn OTA unit NPCs
- `/cid show` - Display CID card
- `/radio` - Radio communication commands
- `/search` - Initiate player search
- `/detain` / `/release` - Detention system
- `/loyalty` - Loyalty management (admin/GO)
- `/tokens` - Token management (admin)

### Security & Administration
- **Server-side Validation**: All critical data validated on server
- **Permission System**: Role-based permissions for different actions
- **Comprehensive Logging**: All player actions logged to database
- **Anti-cheat**: Client modifications cannot affect server data

## Installation

### Requirements
- Minecraft 1.16.5
- Forge 36.2.39
- Java 8+

### Setup
1. Download the mod JAR file
2. Place in your `mods` folder
3. Start the server/client
4. Configuration files will be generated automatically

### Server Setup
- SQLite database will be created automatically in the server directory
- No additional database setup required
- MySQL support available for larger servers

## Configuration

### Client Settings
- HUD position, scale, and transparency
- Key bindings for C-Menu and quick actions
- Language selection (RU/EN)

### Server Settings
- Database configuration
- Economy settings (starting tokens, loyalty)
- Profession requirements and timers
- Security and permission settings

## Development Roadmap

### MVP (v0) - Basic Functionality
- ✅ Player data system with SQLite
- ✅ HUD and C-Menu interfaces
- ✅ Basic items (CID, suitcase, radio)
- ✅ Command system
- ✅ Network synchronization

### v1 - Enhanced Features
- 🔄 NPC profession system
- 🔄 Search/detain GUI interfaces
- 🔄 Economy and ration systems
- 🔄 Door access control
- 🔄 Advanced security mechanics

### v2 - Advanced Systems
- ⏳ Scanner and dispatch systems
- ⏳ Photo evidence system
- ⏳ Bounty and wanted systems
- ⏳ Daily shifts and events
- ⏳ Advanced faction mechanics

## Technical Details

### Architecture
- **Client-Server Architecture**: Mod works on both client and server
- **Data Persistence**: SQLite database with MySQL support
- **Network Protocol**: Custom packet system for synchronization
- **Modular Design**: Separated core, client, and common packages

### Database Schema
- `players`: Core player data (tokens, loyalty, profession)
- `violations`: Player infractions and logs
- `transactions`: Token transaction history
- `loyalty_logs`: Loyalty change tracking
- `suitcases`: Placed suitcase locations
- `radio_logs`: Radio communication logs

### Security
- Server-side data validation
- Encrypted network packets
- Permission-based access control
- Comprehensive audit logging

## Contributing

This mod follows standard Forge development practices:
- Use ForgeGradle for building
- Follow Minecraft/Forge coding conventions
- All player data must be server-validated
- Maintain backwards compatibility

## License

All Rights Reserved - CivilStateRP Development Team

## Support

For issues, feature requests, or questions:
- Check the documentation
- Submit issues to the project repository
- Join the community Discord server

---

**Warning**: This mod is designed for mature roleplay servers. It includes themes related to surveillance, detention, and authoritarian control as part of the Half-Life 2 universe roleplay experience.