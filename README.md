# MUSLIMA AI

A native Android personal AI assistant, built from scratch with Kotlin and Jetpack Compose.

## Project goals

- Premium dark, cyan-blue assistant interface
- Animated 3D-inspired AI core and reactive voice waveform
- Uzbek-first voice and text conversations
- AI provider integration through a secure backend (never commit API keys)
- Android actions such as opening apps, placing calls, and SMS workflows with explicit permissions and user confirmation

## Build

The Android project and GitHub Actions build workflow are being added incrementally. The APK will be produced by CI after the Android build configuration and app source are in place.

## Security

Do not put API keys, passwords, signing credentials, or personal data in this repository. Use GitHub Actions Secrets for build-time secrets and a backend proxy for provider API keys.
