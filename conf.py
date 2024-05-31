import os
import sys

# -- Path setup --------------------------------------------------------------

# If extensions (or modules to document with autodoc) are in another directory,
# add these directories to sys.path here. If the directory is relative to the documentation root, use os.path.abspath to make it absolute, like shown here.
# sys.path.insert(0, os.path.abspath('.'))

# -- Project information -----------------------------------------------------

project = 'Java Spring Boot Weka Reference'
copyright = '2024, James Morse'
author = 'James Morse'

# -- General configuration ---------------------------------------------------

extensions = [
    'recommonmark',
    'sphinx_rtd_theme',
]

# Paths to look for files (here we include the project root and subdirectories)
source_suffix = {
    '.rst': 'restructuredtext',
    '.md': 'markdown',
}

# The master toctree document.
master_doc = 'index'

# -- Options for HTML output -------------------------------------------------

html_theme = 'furo'
html_static_path = ['_static']
templates_path = ['_templates']

# List of patterns, relative to source directory, that match files and directories to ignore when looking for source files.
exclude_patterns = [
    'lib/python3.12/site-packages/**',
    'README.md',
]

